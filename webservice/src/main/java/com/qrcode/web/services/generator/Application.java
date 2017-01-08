package com.qrcode.web.services.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by grijesh on 7/1/17.
 *
 */
@SpringBootApplication
@ComponentScan("com.qrcode")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}