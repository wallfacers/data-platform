package com.wallfacers.data.platform.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动类
 *
 * @author wallfacers
 */
@MapperScan("com.wallfacers.data.platform.dao")
@SpringBootApplication(scanBasePackages = "com.wallfacers.data.platform")
public class DataPlatformWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPlatformWebApplication.class, args);
	}

}
