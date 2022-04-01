package com.example.testtask.api.controller;

import com.example.testtask.api.controller.dto.response.ExampleResponse;
import com.example.testtask.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/resourceName")
public class ExampleController {

    private final ExampleService service;

    @PostMapping("/{operationId}")
    public ExampleResponse process(@PathVariable Long operationId, @RequestParam Map<String, String> params) {
        return service.getEncodedParams(operationId, params);
    }
}
