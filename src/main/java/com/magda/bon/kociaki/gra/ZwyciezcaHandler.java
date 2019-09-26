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
 * Created by Magda on 01.05.2017.
 */
@Component
public class ZwyciezcaHandler implements ApplicationListener <ZwyciezcaEvent> {

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private WebSocketMessageConverter webSocketMessageConverter;

    @Override
    public void onApplicationEvent(ZwyciezcaEvent zwyciezcaEvent) {
        Zwyciezca z = zwyciezcaEvent.getZwyciezca();


        System.out.println("zwyciezca to  : " + z.zwyciezca);

        WebSocketSession dlaZwyciezcy=sessionHandler.getSession(z.zwyciezca.getNazwaUzytkownika());

        try {
            dlaZwyciezcy.sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(z)));

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("oto zwyciezca: " + z.zwyciezca.getNazwaUzytkownika());
    }


}
