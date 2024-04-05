package com.example.data1700oblig2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class HostController {
    public List<Billetter> billettArray = new ArrayList<>();

    //Etter post fra JS har kjørt, havner billett i Billetter-arayet basert på Biletter konstruktøren
    @PostMapping("/lagre")
    void lagre(Billetter billett) {
        billettArray.add(billett);
    }

    //sender info fra billettArray tilbake til JS
    @GetMapping("/hentAlle")
    public List<Billetter> hentAlle() {
        return billettArray;
    }

    @DeleteMapping("/slettAlle")
    public void slettBilletter() {billettArray.clear();}
}

