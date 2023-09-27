package com.iftm.newsletter.controllers;

import com.iftm.newsletter.entities.dtos.NewsDto;
import com.iftm.newsletter.services.NewsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping
    public ResponseEntity<List<NewsDto>> findAll(){
        return service.findAll();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<NewsDto> findById(@PathVariable("id") ObjectId id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<NewsDto> create(@RequestBody NewsDto news) {
        return service.save(news);
    }

    @PutMapping
    public ResponseEntity<NewsDto> update(@RequestBody NewsDto news) {
        return service.update(news);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id){
        return service.delete(id);
    }

}
