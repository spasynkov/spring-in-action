package com.springinaction.pizza.config;

import com.springinaction.pizza.PizzaFlowActions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.springinaction.pizza"}, excludeFilters = {
    @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
    // configuring placeholders bean to work with properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PizzaFlowActions pizzaFlowActions() {
        return new PizzaFlowActions();
    }
}
