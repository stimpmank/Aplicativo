package org.profamilia.registro.config.web;



import javax.servlet.*;

import org.profamilia.registro.config.security.SecurityConfig;
import org.profamilia.registro.config.persistence.HibernateConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
    
    private static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        logger.debug("Inicializando aplicacion . . .");
        
        servletContext.setInitParameter("spring.profiles.active", "local");
        
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();        
        ctx.register(SecurityConfig.class);        
        ctx.register(HibernateConfig.class);        
        ctx.register(WebConfig.class);  
        ctx.setServletContext(servletContext);
        
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}