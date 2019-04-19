package com.paazl.cases.test4;

import java.util.Date;

public class POJO {
    private String name;
    private String city;
    private String country;
    private int number;
    private Date date;

    public POJO(String name, String city, String country, int number, Date date) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "POJO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", number=" + number +
                ", date=" + date +
                '}';
    }
}
