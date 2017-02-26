package com.bylak.mule.esb.spring.event;

import org.apache.log4j.Logger;
import org.mule.module.spring.events.MuleApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringEventSenderBeanExample {

    private static final Logger LOG = Logger.getLogger(SpringEventSenderBeanExample.class);

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void sendEvent() {
        String message = new String("This is a test message");
        LOG.info("Sending message " + message);
        MuleApplicationEvent muleEvent = new MuleApplicationEvent(message, "vm://test");
        applicationContext.publishEvent(muleEvent);
    }
}
