package com.felixseifert.wamprouters.wamp2springpubsubrpc;

import ch.rasc.wamp2spring.WampPublisher;
import ch.rasc.wamp2spring.annotation.WampProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WampController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WampController.class);

    private static final String PROCEDURE = "com.felixseifert.wamprouters.wamp2springpubsubrpc.procedure";

    private static final String TOPIC = "com.felixseifert.wamprouters.wamp2springpubsubrpc.topic";

    @Autowired
    private WampPublisher wampPublisher;

    @WampProcedure(PROCEDURE)
    public int procedure(int arg1, int arg2) {
        LOGGER.info("Procedure called: " + PROCEDURE);
        return arg1 + arg2;
    }

    @Scheduled(initialDelay = 5_000, fixedDelay = 20_000)
    public void publish() {
        LOGGER.info("Published on topic: " + TOPIC);
        wampPublisher.publishToAll(TOPIC,"Hello Subscriber");
    }
}
