package com.jdpay.market.initializer;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;
import java.io.IOException;

public class EmbeddedJetty {

    private static final Logger logger = LoggerFactory.getLogger(EmbeddedJetty.class);
    private static final String CONTEXT_PATH = "/";
    private static final String MAPPING_URL = "/*";

    private static String config_location ="/";
    private static int port = 8080;

    @PostConstruct
    public void initJetty(){
        try {
            System.out.println("1111");
            startJetty(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void startJetty(int port) throws Exception {
        logger.debug("Starting server at port {}", port);
        Server server = new Server(port);
        server.setHandler(getServletContextHandler(getContext()));
        configHttpsConfiguration(server);
        server.start();
        logger.info("Server started at port {}", port);
        server.join();
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        return contextHandler;
    }

    private void configHttpsConfiguration(Server server) {
        HttpConfiguration https_config = new HttpConfiguration();
        https_config.setSecureScheme("https");
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "keystore");
        // 私钥
        sslContextFactory.setKeyStorePassword("123456");
        // 公钥
        sslContextFactory.setKeyManagerPassword("123456");

        ServerConnector httpsConnector = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory, "http/1.1"),
                new HttpConnectionFactory(https_config));
        // 设置访问端口
        httpsConnector.setPort(8443);
        httpsConnector.setIdleTimeout(3000);
        server.addConnector(httpsConnector);
    }


    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(config_location);
        return context;
    }

    public void setConfig_location(String config_location) {
        this.config_location = config_location;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
