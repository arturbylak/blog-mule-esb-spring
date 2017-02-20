package com.bylak.mule.esb.spring.configuration;

import org.mule.module.spring.events.MuleEventMulticaster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MuleConfiguration {

    @Bean
    public MuleEventMulticaster buildEventMulticaster() {
        MuleEventMulticaster muleEventMulticaster = new MuleEventMulticaster();
        String[] subscriptions = new String[] {"vm://event.*"};
        muleEventMulticaster.setSubscriptions(subscriptions);

        return muleEventMulticaster;
    }
}
