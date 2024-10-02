package com.jaqueline.gestionarchivos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 *
 * @author JAQUELINE
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, byte[]> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Configuramos los serializadores
        template.setKeySerializer(new StringRedisSerializer()); // Claves como cadenas
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // Valores como bytes

        return template;
    }
}
