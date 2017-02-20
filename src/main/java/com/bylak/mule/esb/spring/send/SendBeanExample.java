package com.bylak.mule.esb.spring.send;

import org.mule.module.spring.events.MuleApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SendBeanExample {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void sendEvent() {
        Object message = new String("This is a test message");
        MuleApplicationEvent muleEvent = new MuleApplicationEvent(message, "vm://event.test");
        applicationContext.publishEvent(muleEvent);
    }
}
