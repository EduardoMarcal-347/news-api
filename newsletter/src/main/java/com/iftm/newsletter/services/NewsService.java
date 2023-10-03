package com.iftm.newsletter.services;

import com.iftm.newsletter.entities.dtos.LogDto;
import com.iftm.newsletter.entities.dtos.NewsDto;
import com.iftm.newsletter.message.RabbitMqSendLog;
import com.iftm.newsletter.repositories.NewsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository repository;

    @Autowired
    private RabbitMqSendLog rabbitMqSendLog;

    public ResponseEntity<List<NewsDto>> findAll() {
        var dbNews = repository.findAll();
        if (dbNews.isEmpty()) return ResponseEntity.notFound().build();
        var dbNewsDto = dbNews.stream().map(news -> {
            return new NewsDto(news);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dbNewsDto);
    }

    public ResponseEntity<NewsDto> findById(ObjectId id) {
        if (id == null) return ResponseEntity.badRequest().build();

        var news = repository.findById(id);
        if (news.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new NewsDto(news.get()));
    }

    public ResponseEntity<NewsDto> save(NewsDto news) {
        if (news.getTittle().isBlank() || news.getEditorName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        var dbNews = new NewsDto(repository.save(news.toNews()));
        rabbitMqSendLog.sendLog(
                new LogDto("create",
                        Date.from(Instant.now()),
                        dbNews,
                        dbNews.getClass().toString()));
        return ResponseEntity.ok(new NewsDto(repository.save(news.toNews())));
    }

    public ResponseEntity<NewsDto> update(NewsDto news) {
        if (news.getId() == null) return ResponseEntity.badRequest().build();
        if (!repository.findById(new ObjectId(news.getId())).isPresent())
            return ResponseEntity.notFound().build();

        var dbNews = repository.findById(new ObjectId(news.getId())).get();
        dbNews.setDate(news.getDate());
        dbNews.setTittle(news.getTittle());
        dbNews.setPosts(news.getPosts());
        dbNews.setEditorName(news.getEditorName());

        rabbitMqSendLog.sendLog(
                new LogDto("update",
                        Date.from(Instant.now()),
                        dbNews,
                        dbNews.getClass().toString()));
        return ResponseEntity.ok(new NewsDto(repository.save(dbNews)));
    }

    public ResponseEntity<?> delete(ObjectId id) {
        if (id == null) return ResponseEntity.badRequest().build();
        var logNews = new NewsDto(repository.findById(id).get());
        repository.deleteById(id);
        var news = repository.findById(id);
        if (news.isPresent()) return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();

        rabbitMqSendLog.sendLog(
                new LogDto("delete",
                        Date.from(Instant.now()),
                        logNews,
                        logNews.getClass().toString()));
        return ResponseEntity.ok().build();
    }

}
