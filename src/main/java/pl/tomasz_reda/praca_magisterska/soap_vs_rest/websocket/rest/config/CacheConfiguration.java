package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.config;

import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Configuration cache to rest . .
 * @author Tomasz Reda
 * */
@EnableCaching
@Configuration
public class CacheConfiguration implements CachingConfigurer {

    public final static String CACHE_BOOK_CATEGORY = "bookCategoryCache";

    private final Logger log = LoggerFactory
            .getLogger(CacheConfiguration.class);

    @Bean
    @Override
    public CacheManager cacheManager() {
        log.info("Initializing simple Guava Cache manager.");
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        GuavaCache cache_book_category = new GuavaCache(CACHE_BOOK_CATEGORY, CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build());
        cacheManager.setCaches(Arrays.asList(cache_book_category));

        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }

}