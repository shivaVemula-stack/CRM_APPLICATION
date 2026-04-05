package com.telusko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //default bean ID = Config
public class Config {
    public Config(){
        System.out.println("Config Bean Created");
    }

    @Bean
    public Password pwdConfig(){
        Password pwd = new Password("SHA");
        return pwd;
    }

}
