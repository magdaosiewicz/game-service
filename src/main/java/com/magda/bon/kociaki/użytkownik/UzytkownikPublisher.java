package com.magda.bon.kociaki.użytkownik;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Magda on 23.04.2017.
 */
@Component
public class UzytkownikPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher uzytkownikPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher uzytkownikPublisher) {
        this.uzytkownikPublisher = uzytkownikPublisher;
    }

    public void publishOrder(Uzytkownik uzytkownikEvent) {
        uzytkownikPublisher.publishEvent(new UzytkownikEvent(this, uzytkownikEvent));
    }


}
