package com.iftm.logpool.controllers;

import com.iftm.logpool.entities.dtos.LogDto;
import com.iftm.logpool.entities.dtos.NewsDto;
import com.iftm.logpool.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/log")
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping
    public ResponseEntity<List<LogDto<NewsDto>>> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<LogDto<NewsDto>> save(@RequestBody LogDto<NewsDto> logDto) {
        return service.save(logDto);
    }

}
