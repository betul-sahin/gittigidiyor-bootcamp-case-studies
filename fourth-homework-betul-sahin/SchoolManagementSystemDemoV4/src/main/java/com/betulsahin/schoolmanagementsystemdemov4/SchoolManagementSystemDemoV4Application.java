package com.betulsahin.schoolmanagementsystemdemov4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SchoolManagementSystemDemoV4Application {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementSystemDemoV4Application.class, args);
    }
}
