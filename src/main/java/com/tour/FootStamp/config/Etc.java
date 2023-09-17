package com.tour.FootStamp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Etc {
    private String apiKey;
    private String jasyptKey;

    public Etc(
            @Value("${etc.api.key}") String apiKey,
            @Value("${etc.jasypt.key}") String jasyptKey
    ){
        this.apiKey = apiKey;
        this.jasyptKey = jasyptKey;
    }
}
