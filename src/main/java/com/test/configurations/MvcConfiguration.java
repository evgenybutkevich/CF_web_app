package com.test.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.io.File;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String currentPath = String.format("%s%s%s", System.getProperty("user.dir"), File.separatorChar, uploadPath + "/");
        registry.addResourceHandler("/img/**")
            .addResourceLocations("file:///" + currentPath + "/");
    }


}