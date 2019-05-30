package com.cegeka.micro.model;

public class Mudguard {
    private String dimensiune;
    private String culoare;
    private String material;
    private Float pret;

    public Mudguard(String dimensiune, String culoare, String material, Float pret) {
        this.dimensiune = dimensiune;
        this.culoare = culoare;
        this.material = material;
        this.pret = pret;
    }

    public String getDimensiune() {
        return dimensiune;
    }

    public String getCuloare() {
        return culoare;
    }

    public String getMaterial() {
        return material;
    }

    public Float getPret() {
        return pret;
    }

    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }
}
