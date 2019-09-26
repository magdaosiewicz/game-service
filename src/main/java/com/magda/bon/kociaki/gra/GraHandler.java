package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.użytkownik.UzytkownikEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Magda on 09.04.2017.
 */

@Component
public class GraHandler implements ApplicationListener<UzytkownikEvent> {


    @Autowired
    private GraService graService;


    @Override
    public void onApplicationEvent(UzytkownikEvent uzytkownikEvent) {
        Uzytkownik u = uzytkownikEvent.getUzytkownikEvent();

        for (int i = 0; i < graService.gry.size(); i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {

                    System.out.println(graService.gry.get(i).getPlansza()[j][k].toString());
                }

                System.out.println("\n");
            }
        }

        graService.DodajWszystkieGry(u);
        graService.wyswietl();


    }
}
