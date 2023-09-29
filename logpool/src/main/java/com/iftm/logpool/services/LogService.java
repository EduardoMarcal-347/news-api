package com.iftm.logpool.services;

import com.iftm.logpool.entities.dtos.LogDto;
import com.iftm.logpool.entities.dtos.NewsDto;
import com.iftm.logpool.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public ResponseEntity<List<LogDto<NewsDto>>> findAll() {
        var dbLogs = repository.findAll();
        if(dbLogs == null || dbLogs.size() == 0) return ResponseEntity.notFound().build();
        var dbLogsDto = dbLogs.stream().map(log -> {
            return new LogDto<NewsDto>(log);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dbLogsDto);
    }

    public ResponseEntity<LogDto<NewsDto>> save(LogDto logDto) {
        if(logDto.getObject() == null || logDto.getObjectType() == null)
            return ResponseEntity.badRequest().build();
        logDto.setAction("created");
        logDto.setDate(Date.from(Instant.now()));
        var dbLog = repository.save(logDto.toLog());
        return new ResponseEntity<>(new LogDto(dbLog), HttpStatus.CREATED);
    }

}
