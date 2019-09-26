package com.magda.bon.kociaki.wiadomosci;

import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * Created by Magda on 04.04.2017.
 */

@Getter
@NoArgsConstructor
public class Wiadomosc extends WebSocketMessage {


    private Uzytkownik nadawca;
    private Uzytkownik odbiorca;
    private LocalDateTime dataWysylki = now();
    private String trescWiadomosci;

    public Wiadomosc(Uzytkownik nadawca, Uzytkownik odbiorca, LocalDateTime dataWysylki, String trescWiadomosci) {

        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.trescWiadomosci = trescWiadomosci;
        setDataWysylki(dataWysylki);
    }

    public void setDataWysylki(LocalDateTime dataWysylki) {
        if (dataWysylki == null) {
            this.dataWysylki = now();
        } else {
            this.dataWysylki = dataWysylki;
        }
    }
//JA TEŻ !!!

}
















