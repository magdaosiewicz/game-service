package com.magda.bon.kociaki.paczka;

import com.magda.bon.kociaki.użytkownik.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Magda on 13.05.2017.
 */
@RestController
@RequestMapping("/informacjeUzytkownicy")
public class PaczkaRestController {

    @Autowired
    private PaczkaService paczkaService;


    @RequestMapping(value = "/informacjeUzytkownicy", method = RequestMethod.POST)
    public ResponseEntity<?> dajInfoUzytkownicy (@RequestBody Uzytkownik uzytkownik) {

        return ResponseEntity.ok(paczkaService.dajInfoUzytkownicy(uzytkownik));
    }




}
