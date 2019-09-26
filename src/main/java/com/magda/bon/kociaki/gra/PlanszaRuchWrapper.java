package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.wiadomosci.WebSocketMessage;
import lombok.*;

/**
 * Created by Magda on 24.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class PlanszaRuchWrapper extends WebSocketMessage {



    UczestnicyWrapper uczestnicyWrapper;
    Figura plansza[][];
    Uzytkownik obecnyRuch;
    Uzytkownik zwyciezca;

}
