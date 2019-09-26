package com.magda.bon.kociaki.paczka;

import com.magda.bon.kociaki.gra.GraService;
import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.użytkownik.UzytkownikService;
import com.magda.bon.kociaki.wiadomosci.WiadomosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 13.05.2017.
 */
@Service
public class PaczkaService {

    @Autowired
    UzytkownikService uzytkownikService;

    @Autowired
    private WiadomosciService wiadomosciService;

    @Autowired
    private GraService graService;


    public List<PaczkaWrapper> dajInfoUzytkownicy(Uzytkownik uzytkownik) {
        List<PaczkaWrapper> paczkaInfo = new ArrayList<>();

        for (int i = 0; i < uzytkownikService.dajUzytkownikow().size(); i++) {
            if (!uzytkownikService.dajUzytkownikow().get(i).equals(uzytkownik)) {
                PaczkaWrapper paczkaWrapper = new PaczkaWrapper();
                UczestnicyWrapper uczestnicyWrapper = new UczestnicyWrapper(uzytkownik, uzytkownikService.dajUzytkownikow().get(i));

                paczkaWrapper.setGra(graService.znajdzGre(uczestnicyWrapper));
                paczkaWrapper.setWiadomosci(wiadomosciService.pobierzWiadomosciPary(uczestnicyWrapper));
                paczkaWrapper.setUzytkownikZalogowany(uzytkownikService.dajUzytkownikow().get(i));

                paczkaInfo.add(paczkaWrapper);
            }

        }
        return paczkaInfo;
    }

    public PaczkaWrapper dajInfoUzytkownik(Uzytkownik nowyUzytkownik, Uzytkownik staryUzytkownik) {
        UczestnicyWrapper uczestnicyWrapper = new UczestnicyWrapper(nowyUzytkownik, staryUzytkownik);
        return new PaczkaWrapper(nowyUzytkownik, wiadomosciService.pobierzWiadomosciPary(uczestnicyWrapper), graService.znajdzGre(uczestnicyWrapper));

    }


}
