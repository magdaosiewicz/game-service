package com.magda.bon.kociaki.configuration;

import com.magda.bon.kociaki.websocket.ZalogowanyUzytkownik;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.support.WebSocketHttpRequestHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Magda on 24.04.2017.
 */

@Configuration
@EnableWebSocket
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }


    @Bean
    public SimpleUrlHandlerMapping handlerMapping() {

        Map<String, Object> urlMap = new HashMap<String, Object>();

        urlMap.put("/actions", new WebSocketHttpRequestHandler(orderWebSocketHandler()));

        SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
        hm.setOrder(-1);
        hm.setUrlMap(urlMap);



        return hm;
    }

    @Bean
    public WebSocketHandler orderWebSocketHandler() {
        return new ZalogowanyUzytkownik();
    }
}
