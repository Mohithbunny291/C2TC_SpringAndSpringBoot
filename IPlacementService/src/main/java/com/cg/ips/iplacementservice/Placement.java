package com.cg.ips.iplacementservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Placement {

    @Id
    private Integer id;
    private String name;
    private String collage;
    private String date;
    private String qualification;
    private int year;

    public Placement() {
    }

    public Placement(Integer id, String name, String collage, String date, String qualification, int year) {
        this.id = id;
        this.name = name;
        this.collage = collage;
        this.date = date;
        this.qualification = qualification;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collage='" + collage + '\'' +
                ", date='" + date + '\'' +
                ", qualification='" + qualification + '\'' +
                ", year=" + year +
                '}';
    }
}
