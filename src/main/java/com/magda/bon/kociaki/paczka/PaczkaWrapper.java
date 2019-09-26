package com.magda.bon.kociaki.paczka;

import com.magda.bon.kociaki.gra.Gra;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.wiadomosci.WebSocketMessage;
import com.magda.bon.kociaki.wiadomosci.Wiadomosc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 13.05.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaczkaWrapper extends WebSocketMessage {

    Uzytkownik uzytkownikZalogowany;
    List<Wiadomosc> wiadomosci = new ArrayList<>();
    Gra gra;


}
