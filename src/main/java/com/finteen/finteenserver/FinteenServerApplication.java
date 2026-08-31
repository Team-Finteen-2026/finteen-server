package com.finteen.finteenserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FinteenServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinteenServerApplication.class, args);
    }
}