package com.bylak.mule.esb.spring.event;

import org.apache.log4j.Logger;
import org.mule.module.spring.events.MuleApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListenerBeanExample implements ApplicationListener<MuleApplicationEvent> {

    private static final Logger LOG = Logger.getLogger(SpringEventListenerBeanExample.class);

    @Override
    public void onApplicationEvent(final MuleApplicationEvent applicationEvent) {
        LOG.info("Message" + applicationEvent.getSource());
    }
}
