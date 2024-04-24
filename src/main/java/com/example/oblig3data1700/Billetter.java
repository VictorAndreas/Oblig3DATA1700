package com.example.oblig3data1700;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Billetter {
    private Long id;
    private String film;
    private Long antall;
    private String fnavn;
    private String enavn;
    private String tlf;
    private String epost;

    public Billetter(String film, Long antall, String fnavn, String enavn, String tlf, String epost, Long id){
        this.film = film;
        this.antall = antall;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.tlf = tlf;
        this.epost = epost;
        this.id = id;
    }

    public Billetter() {} //Tom konstruktør?

    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }

    public Long getAntall() {
        return antall;
    }

    public void setAntall(Long antall) {
        this.antall = antall;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){this.id = id;} //ikke slett, vet ikke hvorfor
}




