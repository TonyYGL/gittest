package com.example.gittest.init;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "url")
@Component
@Data
public class UrlInit {
    private String devUrl;
    private String stageUrl;
    private String prodUrl;
    private String unknownUrl;
}
