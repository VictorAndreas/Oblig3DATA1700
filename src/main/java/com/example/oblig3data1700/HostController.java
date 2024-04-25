package com.example.oblig3data1700;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

@RestController
public class HostController {

    @Autowired
    BillettRepository repos;

    //Etter post fra JS har kjørt, havner billett i Billetter-arayet basert på Biletter konstruktøren
    @PostMapping("/lagre")
    public void lagreBillett(Billetter kjeks) {
        repos.lagreBillett(kjeks);
        System.out.println("We posted something");
    }

    //sender info fra billettArray tilbake til JS
    @GetMapping("/hentAlle")
    public List<Billetter> hentAlle() {
        List<Billetter> billett = repos.hentAlle();
        //System.out.println(billett);
        Collections.sort(billett, new Comparator<Billetter>() {
            @Override
            public int compare(Billetter b1, Billetter b2) {
                return b1.getEnavn().compareTo(b2.getEnavn()); // Assuming 'getNavn()' returns the name of the Billetter
            }
        });

        return billett;
        //System.out.println();
    }

    @DeleteMapping("/slettAlle")
    public void slettBilletter() {repos.slettAlle();}

    @DeleteMapping("/slettEn")
    public void slettEnkelt(Long id) {
        repos.slettEn(id);
    }

    @PostMapping("/endre")
    public void endreBillett(Billetter billett) {
        repos.endreBillett(billett);
        System.out.println("Antall i billett, Host Controller: "+billett.getAntall());
    }

}



