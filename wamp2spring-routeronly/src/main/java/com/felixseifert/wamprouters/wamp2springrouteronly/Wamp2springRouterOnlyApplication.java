package com.felixseifert.wamprouters.wamp2springrouteronly;

import ch.rasc.wamp2spring.servlet.WampServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Wamp2springRouterOnlyApplication extends WampServletConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Wamp2springRouterOnlyApplication.class, args);
    }

    @Override
    protected String getWebSocketHandlerPath() {
        return "/ws";
    }
}
