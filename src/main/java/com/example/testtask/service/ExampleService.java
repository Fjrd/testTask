package com.example.testtask.service;

import com.example.testtask.api.controller.dto.response.ExampleResponse;

import java.util.Map;

public interface ExampleService {
    ExampleResponse getEncodedParams(Long operationId, Map<String, String> params);
}
