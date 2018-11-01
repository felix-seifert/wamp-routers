package com.felixseifert.wamprouters.wamp2springpubsubrpc;

import ch.rasc.wamp2spring.servlet.WampServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Wamp2springPubsubRpcApplication extends WampServletConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Wamp2springPubsubRpcApplication.class, args);
    }

    @Override
    protected String getWebSocketHandlerPath() {
        return "/ws";
    }
}
