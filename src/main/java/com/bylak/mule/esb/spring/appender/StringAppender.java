package com.bylak.mule.esb.spring.appender;

import org.apache.log4j.Logger;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class StringAppender implements MessageProcessor {
    private static final Logger LOG = Logger.getLogger(StringAppender.class);

    private String suffix;

    public MuleEvent process(MuleEvent event) throws MuleException {
        LOG.info("Processing " + event.getMessage().getPayload());
        event.getMessage().setPayload(event.getMessage().getPayload() + suffix);
        
        return event;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
