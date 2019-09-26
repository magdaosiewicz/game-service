package com.magda.bon.kociaki.koty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kba
 */
@RestController
@RequestMapping("/koty")
public class KotRestController {

    @Autowired
    private KotService kotService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> dajKoty() {
        return ResponseEntity.ok(kotService.dajKoty());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/odglosy")
    public ResponseEntity<?> dajOdglosy() {
        return ResponseEntity.ok(kotService.dajOdglosyKotow());
    }


    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public ResponseEntity<?> dodajKota(@RequestBody Kot kot) {
        kotService.dodajKota(kot);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/zmienGlosKiciorkaBejb", method = RequestMethod.POST)
    public ResponseEntity<?> zmienGlos(@RequestBody Kot kot) {

        kotService.zmienGlos(kot);
        return ResponseEntity.ok().build();
    }


}
