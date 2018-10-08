package com.yxkj.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yxkj.function","com.yxkj.configuration"})
@MapperScan(basePackages = {"com.yxkj.function.tp.mapper","com.yxkj.function.tp.mapper.other"})
@EnableAutoConfiguration
@EnableSwagger2
@EnableEurekaServer
public class GoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodApplication.class, args);
	}
}
