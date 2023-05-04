package com.grandfrais.grandfrais.Application;

import com.grandfrais.grandfrais.Domain.Personne;

public class PersonneVO {
    private Long id;
    private String nom;
    private String prenoms;
    private Integer age;
    private DepartementVO departement;
    public PersonneVO() {}

//    public PersonneVO(Personne personne, DepartementVO departementVo) {
//        this.id = personne.getId();
//        this.nom = personne.getNom();
//        this.prenoms = personne.getPremons();
//        this.age = personne.getAge();
//        this.departement = departementVo;
//    }

    public PersonneVO(Personne personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenoms = personne.getPremons();
        this.age = personne.getAge();
        this.departement = new DepartementVO(personne.getDepartement());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DepartementVO getDepartement() {
        return departement;
    }

    public void setDepartement(DepartementVO departement) {
        this.departement = departement;
    }
}
