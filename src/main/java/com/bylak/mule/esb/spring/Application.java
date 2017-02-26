package com.bylak.mule.esb.spring;

import com.bylak.mule.esb.spring.configuration.ApplicationConfiguration;
import org.apache.log4j.Logger;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MuleClient muleClient = context.getBean(MuleClient.class);

        String payload = "XYZ";
        LOG.info("Sending payload [" + payload + "] to vm://defaultResponse.msg");
        MuleMessage message = muleClient.send("vm://noResponse.msg", payload, null);
        LOG.info("Response: " + message.getPayload());

        LOG.info("Sending payload [" + payload + "] to vm://response.msg");
        message = muleClient.send("vm://response.msg", payload, null);
        LOG.info("Response: " + message.getPayload());

        LOG.info("Sending payload [" + payload + "] to vm://multiResponse.msg");
        message = muleClient.send("vm://multiResponse.msg", payload, null);
        LOG.info("Response: " + message.getPayload());

        LOG.info("Sending payload [" + payload + "] to vm://test");
        message = muleClient.send("vm://test", payload, null);
        LOG.info("Response: " + message.getPayload());
    }
}