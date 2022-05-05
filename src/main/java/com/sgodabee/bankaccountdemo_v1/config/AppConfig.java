package com.sgodabee.bankaccountdemo_v1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.sgodabee.bankaccountdemo_v1"})

public class AppConfig extends WebMvcConfigurationSupport{


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**","images/**","js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/js/","classpath:/static/images/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver()
    {

        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);


        return jspViewResolver;
    }


}
