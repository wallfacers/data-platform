package com.wallfacers.data.platform.server.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.wallfacers.data.platform.server.config.DataPlatformExecutorProperties.PREFIX;


/**
 * Executor 相关配置
 * ManagedChannelConnector
 * 
 * @author wallfacers
 */
@Configuration
@ConfigurationProperties(PREFIX)
public class DataPlatformExecutorProperties {

    public static final String PREFIX = "data.platform.executor";

    /**
     * 执行器服务的IP地址
     */
    private String ip;

    /**
     * 执行器服务的端口
     */
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
