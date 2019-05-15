package com.bing.picturelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class PictureLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureLibraryApplication.class, args);
    }

}
