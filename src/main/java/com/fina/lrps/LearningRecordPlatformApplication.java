package com.fina.lrps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LearningRecordPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningRecordPlatformApplication.class, args);
    }

}
