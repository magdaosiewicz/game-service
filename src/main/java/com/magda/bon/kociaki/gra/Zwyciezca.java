package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import com.magda.bon.kociaki.wiadomosci.WebSocketMessage;
import lombok.*;

/**
 * Created by Magda on 01.05.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Zwyciezca  extends WebSocketMessage {



    Uzytkownik zwyciezca;
}
