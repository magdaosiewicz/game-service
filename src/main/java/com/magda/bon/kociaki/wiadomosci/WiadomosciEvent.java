package com.magda.bon.kociaki.wiadomosci;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Magda on 23.04.2017.
 */
public class WiadomosciEvent extends ApplicationEvent {

    @Getter
    private Wiadomosc wiadomosc;

    public WiadomosciEvent(Object source, Wiadomosc wiadomosc) {
        super(source);
        this.wiadomosc = wiadomosc;
    }


}
