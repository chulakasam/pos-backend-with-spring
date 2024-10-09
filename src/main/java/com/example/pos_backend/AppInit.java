package com.example.pos_backend;

import com.example.pos_backend.config.webAppConfig;
import com.example.pos_backend.config.webAppRootConfig;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{webAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{webAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    //multipart form data handle karanawa
    protected void customizeRegistration(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }
}
