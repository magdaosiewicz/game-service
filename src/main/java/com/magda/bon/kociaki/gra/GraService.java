package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.użytkownik.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Magda on 07.04.2017.
 */


@Service
public class GraService {

    @Autowired
    private RuchPublisher ruchPublisher;

    @Autowired
    private ZwyciezcaPublisher zwyciezcaPublisher;

    @Autowired
    private UzytkownikService uzytkownikService;

    public final List<Gra> gry = new ArrayList<>();


    public void DodajWszystkieGry(Uzytkownik uzytkownikEvent) {
        List<Uzytkownik> uzytkownicy = uzytkownikService.dajUzytkownikow();
        for (int i = 0; i < uzytkownicy.size() - 1; i++) {
            gry.add(new Gra(uzytkownikEvent, uzytkownicy.get(i)));
        }

    }

    public void wyswietl() {

        for (int i = 0; i < gry.size(); i++) {

            System.out.println("idRozgrywki: " + gry.get(i).getIdRozgrywki());
            System.out.println("obecny ruch nalezy do: " + gry.get(i).getObecnyRuch());
            System.out.println("kolko:  " + gry.get(i).getKolko());
            System.out.println("krzyzyk:  " + gry.get(i).getKrzyzyk());
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(gry.get(i).getPlansza()[j][k].name() + "  ");
                }
                System.out.println("");
            }

        }
    }

    Map<UczestnicyWrapper, Gra> myMap = new HashMap<UczestnicyWrapper, Gra>();


    public Gra znajdzGre(UczestnicyWrapper uczestnicyWrapper) {
        Gra znaleniona = new Gra();
        for (int i = 0; i < gry.size(); i++) {
            if (uczestnicyWrapper.getUzytkownik1().equals(gry.get(i).getKolko()) && uczestnicyWrapper.getUzytkownik2().equals(gry.get(i).getKrzyzyk()) || uczestnicyWrapper.getUzytkownik2().equals(gry.get(i).getKolko()) && uczestnicyWrapper.getUzytkownik1().equals(gry.get(i).getKrzyzyk())) {
                znaleniona = gry.get(i);
            }
        }
        return znaleniona;
    }

    public Figura[][] wykonajRuch(RuchWrapper ruchWrapper) {
        Gra gra;
        gra = znajdzGre(ruchWrapper.uczestnicyWrapper);
        gra.wykonajRuch(ruchWrapper);
        ruchPublisher.publishOrderWykonanyRuch(new PlanszaRuchWrapper(ruchWrapper.uczestnicyWrapper, gra.plansza, gra.obecnyRuch, gra.zwyciezca));

        if (gra.zwyciezca != null) {
            zwyciezcaPublisher.publishOrderZwyciezca(new Zwyciezca(gra.zwyciezca));
        }
        return gra.plansza;
    }

    public Gra nowaGra(UczestnicyWrapper uczestnicyWrapper) {
        gry.remove(znajdzGre(uczestnicyWrapper));
        Gra gra = new Gra(uczestnicyWrapper.getUzytkownik1(), uczestnicyWrapper.getUzytkownik2());
        gry.add(gra);
        ruchPublisher.publishOrderWykonanyRuch(new PlanszaRuchWrapper(uczestnicyWrapper, gra.plansza, gra.obecnyRuch, gra.zwyciezca));
        return gra;
    }
}
