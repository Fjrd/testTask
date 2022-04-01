package com.example.testtask.api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class ExampleResponse {

    private Status status;
    private List<String> result;

    @AllArgsConstructor
    public enum Status{
        SUCCESS("success"),
        FAIL("fail");
        private final String status;
    }
}
