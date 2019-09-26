package com.magda.bon.kociaki.wiadomosci;

import com.magda.bon.kociaki.websocket.SessionHandler;
import com.magda.bon.kociaki.websocket.WebSocketMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by Magda on 23.04.2017.
 */
@Component
public class WiadomosciHandler implements ApplicationListener<WiadomosciEvent> {

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private WebSocketMessageConverter webSocketMessageConverter;

    @Override
    public void onApplicationEvent(WiadomosciEvent wiadomosciEvent) {
        Wiadomosc w = wiadomosciEvent.getWiadomosc();


        System.out.print("TRES WIADOMOSVI " + w.getTrescWiadomosci());

        WebSocketSession dlaNadawcy  =sessionHandler.getSession(w.getNadawca().getNazwaUzytkownika());
        WebSocketSession dlaOdbiorcy =sessionHandler.getSession(w.getOdbiorca().getNazwaUzytkownika());;

        try {
            dlaNadawcy.sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(w)));
            dlaOdbiorcy.sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(w)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
