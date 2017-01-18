package com.springinaction.spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc                   // enables Spring MVC
@ComponentScan("com.springinaction.spitter.web")    // enables components scanning
public class WebConfig extends WebMvcConfigurerAdapter {

    /*@Bean                       // configuring jsp views resolver
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);  // enabling JSTL views
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

    @Bean                           // configuring view resolver to work with tiles
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(
                "/WEB-INF/layouts/tiles.xml"/*, "/WEB-INF/viewstiles.xml"*/
        );
        tiles.setCheckRefresh(true);        // enable refresh
        return tiles;
    }

    /*@Bean                         // configuring Thymeleaf
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(ServletContextTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ServletContextTemplateResolver templateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }*/

    /* to work with MultipartFile interface
    @Bean   // defining multipart uploads strategy
    public MultipartResolver multipartResolver() {
        // for lower than Servlet 3.0 use CommonsMultipartResolver from Jakarta Commons FileUpload
        return new StandardServletMultipartResolver();
    }*/

    @Override                   // configuring static content handling
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
