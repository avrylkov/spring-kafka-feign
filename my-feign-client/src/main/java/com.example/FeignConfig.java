package com.example;

import feign.Request;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        //int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 6000);
        //int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 3000);

        //return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
        return new Request.Options(60000, 60000);
    }

    @Bean
    public OkHttpClient client() {
        OkHttpClient okHttpClient = new OkHttpClient();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(1, TimeUnit.MINUTES)
//                .connectTimeout(1, TimeUnit.MINUTES)
//                .build();
        return okHttpClient;
    }
}
