package com.cegeka.micro.model;

public class Horn {
    private String sunet;
    private String vloum;
    private Float pret;

    public Horn(String sunet, String vloum, Float pret) {
        this.sunet = sunet;
        this.vloum = vloum;
        this.pret = pret;
    }

    public String getSunet() {
        return sunet;
    }

    public void setSunet(String sunet) {
        this.sunet = sunet;
    }

    public String getVloum() {
        return vloum;
    }

    public void setVloum(String vloum) {
        this.vloum = vloum;
    }

    public Float getPret() {
        return pret;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }
}
