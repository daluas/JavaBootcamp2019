package com.cegeka.hibernate.model;

/*
c_cnp       numeric(13) PRIMARY KEY,
    c_name      varchar(30) NOT NULL,
    c_email     varchar(30),
    c_tel       numeric(10) NOT NULL
 */


import java.util.Objects;

public class Customer {
    private Integer cnp;
    private String name;
    private String email;
    private Integer telefon;

    public Customer() {
    }

    public Customer(Integer cnp, String name, String email, Integer telefon) {
        this.cnp = cnp;
        this.name = name;
        this.email = email;
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cnp, customer.cnp) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(telefon, customer.telefon);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cnp, name, email, telefon);
    }

    public Integer getCnp() {
        return cnp;
    }

    public void setCnp(Integer cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }
}
