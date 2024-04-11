package com.example.oblig3data1700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class HostController {

    @Autowired
    private BillettRepository repos;

    //Etter post fra JS har kjørt, havner billett i Billetter-arayet basert på Biletter konstruktøren
    @PostMapping("/lagre")
    public void lagreBillett(@RequestBody Billetter billett) {
        repos.lagreBillett(billett);
    }

    //sender info fra billettArray tilbake til JS
    @GetMapping("/hentAlle")
    public List<Billetter> hentAlle() {
        List<Billetter> billett = repos.hentAlle();
        return billett;
    }

    @DeleteMapping("/slettAlle")
    public void slettBilletter() {repos.slettAlle();}
}

