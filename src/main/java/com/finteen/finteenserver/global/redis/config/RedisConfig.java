package com.finteen.finteenserver.global.redis.config;

import com.finteen.finteenserver.global.redis.properties.RedisProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {
    private final RedisProperties properties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(
                properties.getHost(),
                properties.getPort()
        );
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}