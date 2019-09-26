package com.magda.bon.kociaki.użytkownik;

import com.magda.bon.kociaki.paczka.PaczkaService;
import com.magda.bon.kociaki.websocket.SessionHandler;
import com.magda.bon.kociaki.websocket.WebSocketMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Konrad on 27.05.2017.
 */
@Component
public class ZalogowanoUzytkownikaHandler implements ApplicationListener<UzytkownikEvent> {

    @Autowired
    private SessionHandler sessionHandler;

    @Autowired
    private WebSocketMessageConverter webSocketMessageConverter;

    @Autowired
    private UzytkownikService uzytkownikService;

    @Autowired
    private PaczkaService paczkaService;

    @Override
    public void onApplicationEvent(UzytkownikEvent uzytkownikEvent) {
        Map<String, WebSocketSession> sessions = sessionHandler.getSesjaDlaZalogowanego();

        sessions.entrySet().forEach(s -> {
            if (!s.getKey().equals(uzytkownikEvent.getUzytkownikEvent().getNazwaUzytkownika())) {
                try {
                    s.getValue().sendMessage(new TextMessage(webSocketMessageConverter.convertToJson(paczkaService.dajInfoUzytkownik(uzytkownikEvent.getUzytkownikEvent(), uzytkownikService.dajUzytkownik(s.getKey())))));
                } catch (Exception e) {
                }
            }
        });
    }
}
