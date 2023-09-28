package com.iftm.logpool.services;


import com.iftm.logpool.entities.dtos.LogDto;
import com.iftm.logpool.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public ResponseEntity<List<LogDto>> findAll() {
        var dbLogs = repository.findAll();
        if(dbLogs.isEmpty()) return ResponseEntity.notFound().build();
        // TODO: IMPLEMENTAR LogDTO(Log)
        // TODO: CRIAR VIEWSDTO
    }

}
