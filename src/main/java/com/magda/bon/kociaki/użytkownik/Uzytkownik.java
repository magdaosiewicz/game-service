package com.magda.bon.kociaki.użytkownik;

import lombok.*;


/**
 * Created by Magda on 04.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Uzytkownik {

    private String nazwaUzytkownika;

    public String toString()
    {
        return nazwaUzytkownika;
    }

}
