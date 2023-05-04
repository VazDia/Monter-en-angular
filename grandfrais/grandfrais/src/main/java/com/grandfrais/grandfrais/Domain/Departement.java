package com.grandfrais.grandfrais.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dep")
    private Long id_dep;

    @Column(name = "code_departement")
    private String code;

    @Column(name = "designation")
    private String designation;

    @OneToMany(targetEntity = Personne.class, mappedBy = "departement", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Personne> personnes = new HashSet<>();

    public Departement() {}

    public Departement(String code, String designation, Long id_dep) {
        this.code = code;
        this.designation = designation;
        this.id_dep= id_dep;
    }

    public Long getId() {
        return id_dep;
    }

    public void setId(Long id_dep) {
        this.id_dep = id_dep;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
