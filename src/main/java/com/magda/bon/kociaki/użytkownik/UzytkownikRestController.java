package com.magda.bon.kociaki.użytkownik;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Magda on 04.04.2017.
 */

@RestController
@RequestMapping("/uzytkownicy")
public class UzytkownikRestController {


    @Autowired
    private UzytkownikService uzytkownikService;

    @RequestMapping(value = "/dodajUzytkownika", method = RequestMethod.POST)
    public ResponseEntity<?> dodajUzytkownika(@RequestBody Uzytkownik uzytkownik)
    {
        uzytkownikService.dodajUzytkownika(uzytkownik);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> dajUzytkownikow() {
        return ResponseEntity.ok(uzytkownikService.dajUzytkownikow());
    }


}
