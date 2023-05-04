package com.grandfrais.grandfrais.utils.MockBuilder;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Application.PersonneVO;
import com.grandfrais.grandfrais.Domain.Departement;
import com.grandfrais.grandfrais.Domain.Personne;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonneVOMB {
    private Long id;

    private String nom;
    private String prenom;
    private int age;
    private DepartementVO departementVo;

    public PersonneVOMB setId(Long id){
        this.id = id;
        return this;
    }

    public PersonneVOMB setNom(String nom){
        this.nom = nom;
        return this;
    }

    public PersonneVOMB setPrenom(String prenom){
        this.prenom = prenom;
        return this;
    }

    public PersonneVOMB setAge( int age){
        this.age = age ;
        return this;
    }

    public PersonneVOMB setDepartement( DepartementVO departementVo){
        this.departementVo = departementVo;
        return this;
    }

    // Creation du builder

    public PersonneVO build(){

        PersonneVO personneVo = mock(PersonneVO.class);
        when(personneVo.getId()).thenReturn(this.id);
        when(personneVo.getNom()).thenReturn(this.nom);
        when(personneVo.getPrenoms()).thenReturn(this.prenom);
        when(personneVo.getAge()).thenReturn(this.age);
        when(personneVo.getDepartement()).thenReturn(this.departementVo);

        return personneVo;
    }
}
