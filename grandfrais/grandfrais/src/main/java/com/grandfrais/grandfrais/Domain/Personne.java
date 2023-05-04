package com.grandfrais.grandfrais.Domain;

import javax.persistence.*;
@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name="age")
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    private Departement departement;
    public Personne (){}
    public Personne(Long id, String nom, String prenom, int age,Departement departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.departement = departement;
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
    public String getPremons() {
        return prenom;
    }
    public void setPremons(String premons) {
        this.prenom = premons;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
