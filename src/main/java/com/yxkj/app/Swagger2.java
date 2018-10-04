package com.yxkj.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
public class Swagger2 {
//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
    	ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("X-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(tokenPar.build());
        tokenPar.name("X-User").description("用户名").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(tokenPar.build());
        tokenPar.name("dbName").description("库名").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(tokenPar.build());
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.ut.function.user.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 使用 Swagger2 构建RESTful API")
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
 
 
}
