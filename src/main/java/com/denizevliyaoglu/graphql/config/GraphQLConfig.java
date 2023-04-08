package com.denizevliyaoglu.graphql.config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {
    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return new RuntimeWiringConfigurer() {
            @Override
            public void configure(Builder builder) {
                builder.scalar(ExtendedScalars.DateTime);
            }
        };
    }
}
