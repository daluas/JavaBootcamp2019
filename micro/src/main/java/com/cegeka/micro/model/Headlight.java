package com.cegeka.micro.model;

public class Headlight {
    private String culoare;
    private String luminozitate;
    private String alimentare;
    private Float pret;

    public Headlight(String culoare, String luminozitate, String alimentare, Float pret) {
        this.culoare = culoare;
        this.luminozitate = luminozitate;
        this.alimentare = alimentare;
        this.pret = pret;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getLuminozitate() {
        return luminozitate;
    }

    public void setLuminozitate(String luminozitate) {
        this.luminozitate = luminozitate;
    }

    public String getAlimentare() {
        return alimentare;
    }

    public void setAlimentare(String alimentare) {
        this.alimentare = alimentare;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }
}
