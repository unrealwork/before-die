package com.unrealwork.beforedie.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.unrealwork.beforedie")
@PropertySource("classpath:application.properties")
public class ServiceConfiguration {
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    messageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
    return messageSource;
  }
}
