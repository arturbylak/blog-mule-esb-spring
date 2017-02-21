package com.bylak.mule.esb.spring;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.context.MuleContextBuilder;
import org.mule.api.context.MuleContextFactory;
import org.mule.config.DefaultMuleConfiguration;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.module.client.MuleClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application  {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        DefaultMuleConfiguration dmc = new DefaultMuleConfiguration();
        dmc.setId("muleexample");
        dmc.setWorkingDirectory("/esb/mule");
        SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(
                "mule-config.xml");
        MuleContextBuilder contextBuilder = new DefaultMuleContextBuilder();
        contextBuilder.setMuleConfiguration(dmc);
        MuleContextFactory contextFactory = new DefaultMuleContextFactory();
        MuleContext ctx = contextFactory.createMuleContext(configBuilder,
                contextBuilder);
        ctx.start();
        try {
            MuleClient muleClient = new MuleClient(ctx);
            String payload = "XYZ";
            System.out.println("Sending payload [" + payload + "] to vm://defaultResponse.msg");
            MuleMessage message = muleClient.send("vm://noResponse.msg", payload, null);
            System.out.println("Response: " + message.getPayload());

            System.out.println("Sending payload [" + payload + "] to vm://response.msg");
            message = muleClient.send("vm://response.msg", payload, null);
            System.out.println("Response: " + message.getPayload());

            System.out.println("Sending payload [" + payload + "] to vm://multiResponse.msg");
            message = muleClient.send("vm://multiResponse.msg", payload, null);
            System.out.println("Response: " + message.getPayload());

            System.out.println("Sending payload [" + payload + "] to vm://test");
            message = muleClient.send("vm://test", payload, null);
            System.out.println("Response: " + message.getPayload());
        } finally {
            ctx.dispose();
        }
    }
}