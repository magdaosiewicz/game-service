package com.magda.bon.kociaki.użytkownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 04.04.2017.
 */
@Service
public class UzytkownikService {


    @Autowired
    private UzytkownikPublisher uzytkownikPublisher;

    private final List<Uzytkownik> uzytkownicy = new ArrayList<>();

    public void dodajUzytkownika(Uzytkownik uzytkownik)

    {
        System.out.println("Sprawdzamy, czy dziala");

        uzytkownicy.add(uzytkownik);
        uzytkownikPublisher.publishOrder(uzytkownik);


    }

    public List<Uzytkownik> dajUzytkownikow() {
        return uzytkownicy;
    }

    public Uzytkownik dajUzytkownik(String nazwaUzytkownika) {
        return uzytkownicy.stream().filter(uzytkownik -> uzytkownik.getNazwaUzytkownika().equals(nazwaUzytkownika)).findFirst().get();
    }


}
