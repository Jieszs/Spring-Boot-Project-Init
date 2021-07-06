package com.jiesz.init.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 *
 * @author zj
 * @date 2019/12/10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiesz.init.controller"))
                .paths(PathSelectors.any())
                .build()             //添加登录认证
                .globalRequestParameters(params());
    }

    private List<RequestParameter> params() {
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder();

        List<RequestParameter> requestParameters = new ArrayList<>();
        RequestParameter token = parameterBuilder.name(HttpHeaders.AUTHORIZATION).description("token").in(ParameterType.HEADER)
                .required(false).build();
        requestParameters.add(token);
        return requestParameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall-tiny")
                .contact(new Contact("macro", null, null))
                .version("1.0")
                .build();
    }


}
