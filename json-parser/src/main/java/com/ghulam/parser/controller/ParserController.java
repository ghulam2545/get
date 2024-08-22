package com.ghulam.parser.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghulam.parser.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParserController {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    AppService service;

    @PostMapping(path = "/parser")
    public Object parser(@RequestBody JsonNode json) {
        return service.parse(json);
    }
}
