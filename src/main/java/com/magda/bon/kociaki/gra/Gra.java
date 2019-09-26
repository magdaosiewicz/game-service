package com.magda.bon.kociaki.gra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

/**
 * Created by Magda on 07.04.2017.
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gra {


    static int iidRozgrywki = 0;
    int idRozgrywki;

    Uzytkownik obecnyRuch;
    Uzytkownik kolko;
    Uzytkownik krzyzyk;
    Uzytkownik zwyciezca = null;

    Gra(Uzytkownik uzytkownik1, Uzytkownik uzytkownik2) {
        this.idRozgrywki = iidRozgrywki++;
        this.kolko = uzytkownik1;
        this.krzyzyk = uzytkownik2;
        this.idRozgrywki = idRozgrywki;

        Random r = new Random();
        int a = r.nextInt(11);
        if (a % 2 == 1) {
            this.obecnyRuch = kolko;
        } else {
            this.obecnyRuch = krzyzyk;
        }
    }


    Figura[][] plansza = {{Figura.PUSTO, Figura.PUSTO, Figura.PUSTO}, {Figura.PUSTO, Figura.PUSTO, Figura.PUSTO}, {Figura.PUSTO, Figura.PUSTO, Figura.PUSTO},};


    public Figura[][] wykonajRuch(RuchWrapper ruchWrapper) {

        if ((ruchWrapper.getWykonujacyRuch().getNazwaUzytkownika().equals(obecnyRuch.getNazwaUzytkownika()) && plansza[ruchWrapper.getI()][ruchWrapper.getJ()].equals(Figura.PUSTO)) && (plansza[0][0].equals(Figura.PUSTO) || plansza[0][1].equals(Figura.PUSTO) || plansza[0][2].equals(Figura.PUSTO) || plansza[1][0].equals(Figura.PUSTO) || plansza[1][1].equals(Figura.PUSTO) || plansza[1][2].equals(Figura.PUSTO) || plansza[2][0].equals(Figura.PUSTO) || plansza[2][1].equals(Figura.PUSTO) || plansza[2][2].equals(Figura.PUSTO))) {
            if (obecnyRuch.equals(kolko)) {
                plansza[ruchWrapper.getI()][ruchWrapper.getJ()] = Figura.KOLKO;
                obecnyRuch = krzyzyk;
            } else {
                plansza[ruchWrapper.getI()][ruchWrapper.getJ()] = Figura.KRZYZYK;
                obecnyRuch = kolko;
            }

        }


        if (obecnyRuch.equals(kolko) && (plansza[0][0].equals(plansza[0][1]) && plansza[0][1].equals(plansza[0][2]) && plansza[0][0].equals(Figura.KRZYZYK) || plansza[1][0].equals(plansza[1][1]) && plansza[1][1].equals(plansza[1][2]) && plansza[1][1].equals(Figura.KRZYZYK) || plansza[2][0].equals(plansza[2][1]) && plansza[2][0].equals(plansza[2][2]) && plansza[2][2].equals(Figura.KRZYZYK) || plansza[0][0].equals(plansza[1][0]) && plansza[2][0].equals(plansza[1][0]) && plansza[0][0].equals(Figura.KRZYZYK) || plansza[0][1].equals(plansza[1][1]) && plansza[2][1].equals(plansza[1][1]) && plansza[1][1].equals(Figura.KRZYZYK) || plansza[0][2].equals(plansza[1][2]) && plansza[2][2].equals(plansza[1][2]) && plansza[2][2].equals(Figura.KRZYZYK) || plansza[0][0].equals(plansza[1][1]) && plansza[2][2].equals(plansza[1][1]) && plansza[0][0].equals(Figura.KRZYZYK) || plansza[0][2].equals(plansza[1][1]) && plansza[2][0].equals(plansza[1][1]) && plansza[2][0].equals(Figura.KRZYZYK) )) {
            zwyciezca = krzyzyk;
            System.out.println("a otoo zwyciezca:  " + zwyciezca.getNazwaUzytkownika());
        }
        if (obecnyRuch.equals(krzyzyk) && (plansza[0][0].equals(plansza[0][1]) && plansza[0][1].equals(plansza[0][2]) && plansza[0][0].equals(Figura.KOLKO) || plansza[1][0].equals(plansza[1][1]) && plansza[1][1].equals(plansza[1][2]) && plansza[1][1].equals(Figura.KOLKO) || plansza[2][0].equals(plansza[2][1]) && plansza[2][0].equals(plansza[2][2]) && plansza[2][2].equals(Figura.KOLKO) || plansza[0][0].equals(plansza[1][0]) && plansza[2][0].equals(plansza[1][0]) && plansza[0][0].equals(Figura.KOLKO) || plansza[0][1].equals(plansza[1][1]) && plansza[2][1].equals(plansza[1][1]) && plansza[1][1].equals(Figura.KOLKO) || plansza[0][2].equals(plansza[1][2]) && plansza[2][2].equals(plansza[1][2]) && plansza[2][2].equals(Figura.KOLKO) || plansza[0][0].equals(plansza[1][1]) && plansza[2][2].equals(plansza[1][1]) && plansza[0][0].equals(Figura.KOLKO) ||   plansza[0][2].equals(plansza[1][1]) && plansza[2][0].equals(plansza[1][1]) && plansza[2][0].equals(Figura.KOLKO))) {
            zwyciezca = kolko;
            System.out.println("a otoo zwyciezca:  " + zwyciezca.getNazwaUzytkownika());
        }


        return plansza;
    }


}