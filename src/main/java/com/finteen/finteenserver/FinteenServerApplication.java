package com.finteen.finteenserver;

import com.finteen.finteenserver.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class FinteenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinteenServerApplication.class, args);
    }

}
