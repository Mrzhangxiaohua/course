package com.spc;

//import net.unicon.cas.client.configuration.EnableCasClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//@EnableCasClient
public class Springboot2MybatisDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Springboot2MybatisDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
    }
}
