// package com.example.employee_application.Config;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.cache.RedisCacheConfiguration;
// import org.springframework.data.redis.cache.RedisCacheManager;
// import org.springframework.data.redis.connection.RedisConnectionFactory;

// @Configuration
// @EnableCaching
// public class RedisCacheConfig {
////RedisCcaheManager - manages all caches, RedisCcaheConfiguration - rules for particular cache 
//     @Bean
//     public RedisCacheManager cacheManager(
//             RedisConnectionFactory connectionFactory) {

//         // Employee Cache - 10 Minutes
//         RedisCacheConfiguration employeeCacheConfig =
//                 RedisCacheConfiguration.defaultCacheConfig()
//                         .entryTtl(Duration.ofMinutes(10))
//                         .disableCachingNullValues();

//         // Project Assignment Cache - 4 Minutes
//         RedisCacheConfiguration projectAssignmentCacheConfig =
//                 RedisCacheConfiguration.defaultCacheConfig()
//                         .entryTtl(Duration.ofMinutes(4))
//                         .disableCachingNullValues();

//         Map<String, RedisCacheConfiguration> cacheConfigurations =
//                 new HashMap<>();

//         cacheConfigurations.put(
//                 "employees",
//                 employeeCacheConfig);

//         cacheConfigurations.put(
//                 "projectassignment",
//                 projectAssignmentCacheConfig);

//         return RedisCacheManager.builder(connectionFactory)
//                 .withInitialCacheConfigurations(cacheConfigurations)
//                 .build();
//     }
// }