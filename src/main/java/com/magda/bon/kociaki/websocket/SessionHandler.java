package com.magda.bon.kociaki.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Magda on 29.04.2017.
 */
@Component
public class SessionHandler {


    private final Map<String, WebSocketSession> sesjaDlaZalogowanego = new ConcurrentHashMap<>();


    public void addNewUSer(String nazwaUzytkownika, WebSocketSession webSocketSession) {
        sesjaDlaZalogowanego.put(nazwaUzytkownika, webSocketSession);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public WebSocketSession getSession(String nazwaUzytkownika) {
        return sesjaDlaZalogowanego.get(nazwaUzytkownika);
    }

    public Map<String, WebSocketSession> getSesjaDlaZalogowanego() {
        return sesjaDlaZalogowanego;
    }

}
