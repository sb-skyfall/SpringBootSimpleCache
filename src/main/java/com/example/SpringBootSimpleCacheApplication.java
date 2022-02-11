package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class SpringBootSimpleCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSimpleCacheApplication.class, args);
    }

//    @Bean
//    public CacheManager cacheManager(){
//        return new ConcurrentMapCacheManager("ticketsCache");
//    }

}
