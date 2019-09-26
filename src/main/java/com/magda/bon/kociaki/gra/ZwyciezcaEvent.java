package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Magda on 01.05.2017.
 */
public class ZwyciezcaEvent  extends ApplicationEvent {


    @Getter
    Zwyciezca zwyciezca;

    public ZwyciezcaEvent(Object source, Zwyciezca zwyciezca) {
        super(source);
        this.zwyciezca = zwyciezca;
    }

}
