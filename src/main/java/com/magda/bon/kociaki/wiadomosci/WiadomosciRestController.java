package com.magda.bon.kociaki.wiadomosci;


import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
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
@RequestMapping("/wiadomosci")
public class WiadomosciRestController {

    @Autowired
    private WiadomosciService wiadomosciService;


    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public ResponseEntity<?> wyslijWiadomosc(@RequestBody Wiadomosc wiadomosc) {
        wiadomosciService.wyslijWiadomosc(wiadomosc);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> dajWiadomosci()

    {
        return ResponseEntity.ok(wiadomosciService.dajWiadomosci());
    }


    @RequestMapping(value = "/pobierzWiadomosciPary", method = RequestMethod.POST)
    public ResponseEntity<?> pobierzWiadomosciPary(@RequestBody UczestnicyWrapper uczestnicyWrapper) {
        return ResponseEntity.ok(wiadomosciService.pobierzWiadomosciPary(uczestnicyWrapper));
    }


}
