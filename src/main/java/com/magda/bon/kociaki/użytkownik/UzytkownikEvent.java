package com.magda.bon.kociaki.użytkownik;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Magda on 24.04.2017.
 */
public class UzytkownikEvent extends ApplicationEvent {


    @Getter
    private Uzytkownik uzytkownikEvent;

    public UzytkownikEvent(Object source, Uzytkownik uzytkownikEvent) {
        super(source);
        this.uzytkownikEvent = uzytkownikEvent;
    }


}
