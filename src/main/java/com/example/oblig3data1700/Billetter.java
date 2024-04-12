package com.example.oblig3data1700;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class Billetter {
    private int id;
    private String film;
    private int antall;
    private String fnavn;
    private String enavn;
    private String tlf;
    private String epost;

    public Billetter(String film, int antall, String fnavn, String enavn, String tlf, String epost){
        this.film = film;
        this.antall = antall;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.tlf = tlf;
        this.epost = epost;
    }

    public Billetter() {} //Tom konstruktør?

    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
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
}
