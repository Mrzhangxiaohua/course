package com.spc;

//import net.unicon.cas.client.configuration.EnableCasClient;

import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.ServletContext;

//@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
//@EnableCasClient
public class Springboot2MybatisDemoApplication extends SpringBootServletInitializer {

    public Springboot2MybatisDemoApplication() {
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Springboot2MybatisDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot2MybatisDemoApplication.class, args);

    }
}
