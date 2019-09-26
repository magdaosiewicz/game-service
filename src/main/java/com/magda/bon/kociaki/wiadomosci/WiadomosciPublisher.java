package com.magda.bon.kociaki.wiadomosci;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Magda on 23.04.2017.
 */
@Component
public class WiadomosciPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher wiadomoscPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher wiadomoscPublisher) {
        this.wiadomoscPublisher = wiadomoscPublisher;
    }

    public void publishOrder(Wiadomosc wiadomoscEvent) {
        wiadomoscPublisher.publishEvent(new WiadomosciEvent(this, wiadomoscEvent));
    }


}
