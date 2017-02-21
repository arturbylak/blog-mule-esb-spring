package com.bylak.mule.esb.spring.send;

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
        System.out.println("Print ln");
    }
}
