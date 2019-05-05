package com.wenl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "com.wenl")
@MapperScan("com.wenl.dao")//将项目中对应的mapper接口的路径加进来就可以了
public class App extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(App.class);
    }

    public static void main( String[] args ){
        SpringApplication.run(App.class,args);
    }
}
