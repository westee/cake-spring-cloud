package com.westee.goodsservice.service;

import com.westee.goodsservice.generate.Config;
import com.westee.goodsservice.generate.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfigService {
    private final ConfigMapper configMapper;

    @Autowired
    public ConfigService(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    public Config getConfig() {
        return configMapper.selectByPrimaryKey(1);
    }

    public Config updateConfig(Config config) {
        config.setId(1);
        config.setUpdatedAt(LocalDateTime.now());
        configMapper.updateByPrimaryKeySelective(config);
        return config;
    }
}
