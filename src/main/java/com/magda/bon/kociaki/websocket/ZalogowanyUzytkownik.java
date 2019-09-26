package com.magda.bon.kociaki.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Magda on 24.04.2017.
 */
@Component
public class ZalogowanyUzytkownik  extends TextWebSocketHandler {

    @Autowired
    private WebSocketMessageConverter webSocketMessageConverter;

    @Autowired
    private SessionHandler sessionHandler;

    @Override
    public void afterConnectionEstablished(WebSocketSession session)
    {

    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        WebSocketIncomingMessage webSocketIncomingMessage = webSocketMessageConverter.convertToObject(message);
        sessionHandler.addNewUSer(webSocketIncomingMessage.getNazwaUzytkownika(), session);

        System.out.println("Dodano uzytkownika do mapy " + webSocketIncomingMessage.getNazwaUzytkownika());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
    {
    //    webSocketActionService.removeSession(session);
    }





}
