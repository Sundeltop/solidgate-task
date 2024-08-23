package com.example.config;

import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConfigManager {

    public static Configuration configuration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
