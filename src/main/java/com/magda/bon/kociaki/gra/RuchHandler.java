package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.websocket.SessionHandler;
import com.magda.bon.kociaki.websocket.WebSocketMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by Magda on 24.04.2017.
 */
@Component
public class RuchHandler implements ApplicationListener<RuchEvent> {

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private WebSocketMessageConverter webSocketMessageConverter;


    @Override
    public void onApplicationEvent(RuchEvent ruchEvent) {
        PlanszaRuchWrapper wE = ruchEvent.getPlanszaRuchWrapper();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(wE.getPlansza()[i][j] + "  ");
            }
            System.out.println();
        }

        WebSocketSession dlaUzytkownika1=sessionHandler.getSession(wE.getUczestnicyWrapper().getUzytkownik1().getNazwaUzytkownika());
        WebSocketSession dlaUzytkownika2=sessionHandler.getSession(wE.getUczestnicyWrapper().getUzytkownik2().getNazwaUzytkownika());

        try {
            dlaUzytkownika1.sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(wE)));
            dlaUzytkownika2.sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(wE)));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
