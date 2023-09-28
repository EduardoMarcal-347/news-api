package com.iftm.logpool.services;


import com.iftm.logpool.entities.Log;
import com.iftm.logpool.entities.dtos.LogDto;
import com.iftm.logpool.entities.dtos.NewsDto;
import com.iftm.logpool.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public ResponseEntity<List<LogDto<NewsDto>>> findAll() {
        var dbLogs = repository.findAll();
        if(dbLogs.isEmpty()) return ResponseEntity.notFound().build();
        var dbLogsDto = dbLogs.stream().map(log -> {
            return new LogDto<NewsDto>(log);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dbLogsDto);
    }

    public ResponseEntity<LogDto<NewsDto>> save(LogDto<NewsDto> logDto) throws URISyntaxException {
        if(logDto.getAction().isBlank() || logDto.getObject() == null)
            return ResponseEntity.badRequest().build();
        var dbLog = repository.save(logDto.toLog());
        return new ResponseEntity<>(new LogDto(dbLog), HttpStatus.CREATED);
    }

}
