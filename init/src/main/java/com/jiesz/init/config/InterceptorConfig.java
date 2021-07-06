package com.jiesz.init.config;


import com.jiesz.init.common.Namespace;
import com.jiesz.init.handle.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private static final String ROOT = "/" + Namespace.API;

    @Resource
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns(ROOT + "/**")//拦截ROOT下的所有请求
                .excludePathPatterns(ROOT + "/" + Namespace.TOKEN + "/**");
    }

}
