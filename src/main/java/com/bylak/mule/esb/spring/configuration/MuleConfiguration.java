package com.bylak.mule.esb.spring.configuration;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextBuilder;
import org.mule.api.context.MuleContextFactory;
import org.mule.config.DefaultMuleConfiguration;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.module.client.MuleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MuleConfiguration {

    private static final String WORKING_DIRECTORY = "/esb/mule";
    private static final String ID = "muleexample";
    private static final String MULE_CONFIG_FILE = "mule-config.xml";

    @Bean
    @Autowired
    public MuleContext muleContext(AnnotationConfigApplicationContext applicationContext) throws MuleException {
        DefaultMuleConfiguration defaultMuleConfiguration = new DefaultMuleConfiguration();
        defaultMuleConfiguration.setId(ID);
        defaultMuleConfiguration.setWorkingDirectory(WORKING_DIRECTORY);

        SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(MULE_CONFIG_FILE);
        configBuilder.setParentContext(applicationContext);
        MuleContextBuilder muleContextBuilder = new DefaultMuleContextBuilder();
        muleContextBuilder.setMuleConfiguration(defaultMuleConfiguration);

        MuleContextFactory contextFactory = new DefaultMuleContextFactory();
        MuleContext muleContext = contextFactory.createMuleContext(configBuilder, muleContextBuilder);
        muleContext.start();

        return muleContext;
    }

    @Bean
    @Autowired
    public MuleClient muleClient(MuleContext muleContext) throws MuleException {
        return new MuleClient(muleContext);
    }
}
