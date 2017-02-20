package com.bylak.mule.esb.spring;

import org.mule.api.MuleContext;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

//@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... strings) throws Exception {
//        DefaultMuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
//        SpringXmlConfigurationBuilder configBuilder = null;
//        try {
//            StaticApplicationContext staticApplicationContext = new StaticApplicationContext(context);
//            configBuilder = new SpringXmlConfigurationBuilder("mule-config.xml");
//            staticApplicationContext.refresh();
//            configBuilder.setParentContext(staticApplicationContext);
//            MuleContext muleContext = muleContextFactory.createMuleContext(configBuilder);
//            muleContext.start();
//            log.info("Started Mule!");
//        } catch (Exception e) {
//            log.error("Error starting Mule...", e);
//        }
//
//        MuleContext muleContext = new DefaultMuleContextFactory().createMuleContext();
//
////        muleContext.
//
//        ConfigurationBuilder builder2 = new SpringXmlConfigurationBuilder("mule-config.xml");
//        builder2.configure(muleContext);
//
//        muleContext.start();

        MuleContext muleContext = new DefaultMuleContextFactory().createMuleContext();

        ConfigurationBuilder builder = new SpringXmlConfigurationBuilder("spring-beans.xml, mule-config.xml");
        builder.configure(muleContext);

        muleContext.start();
    }

    public static void main(String[] args) {
        log.info("Starting SpringApplication...");
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(false);
        app.run(args);
        log.info("SpringApplication has started...");
    }
}