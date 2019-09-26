package com.magda.bon.kociaki.koty;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kba
 */
@Service
public class KotService {

    private final List<Kot> koty = new ArrayList<>();
    //private Kot kicius= new Kot();

    public void dodajKota(Kot kot) {
        koty.add(kot);
    }

    public List<Kot> dajKoty() {
        return koty;
    }


    public List<String> dajOdglosyKotow() {


        return koty.stream().map(kot -> kot.getOdglos()).collect(Collectors.toList());
    }


    public void zmienGlos(Kot kot) {
        for (int i = 0; i < koty.size(); i++) {
            if (koty.get(i).getImie().equals(kot.getImie())) {
                koty.get(i).setOdglos(kot.getOdglos());
            }
        }
    }


}
