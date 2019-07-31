package com.pirateway.scrapper.frontend.primefaces;


import com.ocpsoft.pretty.PrettyFilter;
import com.pirateway.scrapper.frontend.primefaces.api.service.IBetService;
import com.pirateway.scrapper.frontend.primefaces.api.service.IForkService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.List;

import static com.pirateway.scrapper.frontend.primefaces.util.ElementsPath.*;

@SpringBootApplication()
public class ScrapperFrontendPrimefacesApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ScrapperFrontendPrimefacesApp.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
    }

    @Bean
    public FilterRegistrationBean prettyFilter() {
        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new PrettyFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }

}
