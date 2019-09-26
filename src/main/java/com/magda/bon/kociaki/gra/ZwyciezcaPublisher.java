package com.magda.bon.kociaki.gra;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Magda on 01.05.2017.
 */
@Component
public class ZwyciezcaPublisher implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher zwyciezcaPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher zwyciezcaPublisher) {
        this.zwyciezcaPublisher = zwyciezcaPublisher;
    }

    public void publishOrderZwyciezca(Zwyciezca zwyciezca) {
        zwyciezcaPublisher.publishEvent(new ZwyciezcaEvent(this, zwyciezca));

        System.out.println("oto zwyciezca: " + zwyciezca);
    }


}
