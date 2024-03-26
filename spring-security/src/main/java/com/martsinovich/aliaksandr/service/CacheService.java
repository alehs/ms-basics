package com.martsinovich.aliaksandr.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CacheService<T> {

  private static final Logger log = LoggerFactory.getLogger(CacheService.class);

  private final Cache<String, T> cache;

  private long maxBlockTimeSec;

  public CacheService(@Value("${brute-force.login-timeout:60}") long maxBlockTimeSec) {
    cache = CacheBuilder.newBuilder()
        .expireAfterWrite(maxBlockTimeSec, TimeUnit.SECONDS)
        .concurrencyLevel(Runtime.getRuntime().availableProcessors())
        .build();
  }

  public T get(String key) {
    return cache.getIfPresent(key);
  }

  public Collection<T> getAll() {
    return cache.asMap().values();
  }

  public void add(String key, T value) {
    cache.put(key, value);
    log.info("Record stored cache with key: {}, value: {}", key, value);
  }

  public void remove(String email) {
    cache.invalidate(email);
  }
}
