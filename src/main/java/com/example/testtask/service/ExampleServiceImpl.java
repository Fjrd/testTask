package com.example.testtask.service;

import com.example.testtask.api.controller.dto.response.ExampleResponse;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.testtask.api.controller.dto.response.ExampleResponse.Status.*;

@Service
public class ExampleServiceImpl implements ExampleService{

    @Override
    public ExampleResponse getEncodedParams(Long operationId, Map<String, String> params) {

        String paramString = params.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));

        String encodedString = encode(paramString);

        return ExampleResponse.builder()
                .status(SUCCESS)
                .result(Collections.singletonList(encodedString))
                .build();
    }

    private String encode(String data) {
        byte[] key = "secret".getBytes();
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key);
        return hm256.hmacHex(data);
    }
}
