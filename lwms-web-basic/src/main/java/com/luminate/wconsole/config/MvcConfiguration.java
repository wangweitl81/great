package com.luminate.wconsole.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * The SpringMVC application context.
 *
 * This is the annotation variation of configuring the SpringMVC application
 * context. An XML configuration is imported so XML based configuration can
 * still be used.
 *
 * Any @Controller classes will be picked up by component scanning. All other
 * components are ignored as they will be picked up by the root application
 * context.
 */
@EnableWebMvc
@Configuration
@ComponentScan(useDefaultFilters = false, basePackages = {"com.luminate.wconsole"},
        includeFilters = {@ComponentScan.Filter(Controller.class)})
@ImportResource("classpath:META-INF/spring/servlet-context.xml")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /* Mapping to the login view. */
        registry.addViewController("/login").setViewName("login");

    }

    /**
     * Allow the default servlet to serve static files from the webapp root.
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
   @Bean
    public InternalResourceViewResolver staticViewResolver() {
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    	resolver.setViewNames(new String[]{"*.htm"});
    	resolver.setPrefix("/WEB-INF/views/");
    	resolver.setCache(false);
    	return resolver;
    }

   @Bean
   public InternalResourceViewResolver redirectViewResolver() {
   	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
   	resolver.setViewNames(new String[]{"redirect*"});
//   	resolver.setPrefix("/WEB-INF/views/");
   	return resolver;
   }   
   
    @Bean
    public ServletContextTemplateResolver thymeleafTemplateResolver() {
        ServletContextTemplateResolver resolver =
                new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(true);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(thymeleafTemplateResolver());
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(thymeleafTemplateEngine());
        resolver.setViewNames(new String[]{"*.html"});
        return resolver;
    }

}
