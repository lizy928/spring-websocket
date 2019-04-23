package com.panda.socketprogramming;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {CustomConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] { "/", "*.js", "*.css", "*.jpg", "*.png", "/app/*", "*.map" };
    }
}
