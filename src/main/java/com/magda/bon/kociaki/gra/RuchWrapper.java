package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import lombok.*;

/**
 * Created by Magda on 10.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class RuchWrapper {

    UczestnicyWrapper uczestnicyWrapper;
    Uzytkownik wykonujacyRuch;
    int i, j;

}
