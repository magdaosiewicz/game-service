package com.magda.bon.kociaki.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
@Log4j2
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.magda.bon.kociaki"}, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ContextConfiguration {

    @Bean
    @Primary
    public ObjectMapper webSocketJacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
