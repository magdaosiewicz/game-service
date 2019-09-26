package com.magda.bon.kociaki.wiadomosci;

import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 04.04.2017.
 */
@Service
public class WiadomosciService {

    @Autowired
    private WiadomosciPublisher wiadomosciPublisher;

    private final List<Wiadomosc> wiadomosc = new ArrayList<>();

    public void wyslijWiadomosc(Wiadomosc wiadomosc) {
        this.wiadomosc.add(wiadomosc);
        wiadomosciPublisher.publishOrder(wiadomosc);
    }

    public List<Wiadomosc> dajWiadomosci() {
        return wiadomosc;
    }

    public List<Wiadomosc> pobierzWiadomosciPary(UczestnicyWrapper uczestnicyWrapper) {
        List<Wiadomosc> wiadomosc_pary = new ArrayList<>();

        for (int i = 0; i < wiadomosc.size(); i++) {
            Wiadomosc wiad = wiadomosc.get(i);
            if (wiad.getNadawca().getNazwaUzytkownika().equals(uczestnicyWrapper.getUzytkownik1().getNazwaUzytkownika()) && wiad.getOdbiorca().getNazwaUzytkownika().equals(uczestnicyWrapper.getUzytkownik2().getNazwaUzytkownika()) || wiad.getNadawca().getNazwaUzytkownika().equals(uczestnicyWrapper.getUzytkownik2().getNazwaUzytkownika()) && wiad.getOdbiorca().getNazwaUzytkownika().equals(uczestnicyWrapper.getUzytkownik1().getNazwaUzytkownika())) {

                wiadomosc_pary.add(wiad);
            }

        }
        return wiadomosc_pary;
    }


}
