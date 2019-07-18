package com.stackroute.keepnote.Config;

        import org.springframework.web.WebApplicationInitializer;
        import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
        import org.springframework.web.servlet.DispatcherServlet;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRegistration;

 class DispatcherServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(Config.class);
        webCtx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new org.springframework.web.servlet.DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}