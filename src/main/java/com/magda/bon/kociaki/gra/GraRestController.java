package com.magda.bon.kociaki.gra;

import com.magda.bon.kociaki.użytkownik.UczestnicyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Magda on 07.04.2017.
 */


@RestController
@RequestMapping("/gra")
public class GraRestController {

    @Autowired
    private GraService graService;


    @RequestMapping(value = "/wykonajRuchBejb", method = RequestMethod.POST)
    public ResponseEntity<?> wykonajRuch(@RequestBody RuchWrapper ruchWrapper) {
        return ResponseEntity.ok(graService.wykonajRuch(ruchWrapper));
    }

    @RequestMapping(value = "/nowaGra", method = RequestMethod.POST)
    public ResponseEntity<?> nowaGra(@RequestBody UczestnicyWrapper uczestnicyWrapper) {
        return ResponseEntity.ok(graService.nowaGra(uczestnicyWrapper));
    }
}