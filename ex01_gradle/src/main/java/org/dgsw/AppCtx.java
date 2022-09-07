package org.dgsw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.dgsw"})
public class AppCtx {

    @Bean
    public A a() {
        return new A();
    }

}
