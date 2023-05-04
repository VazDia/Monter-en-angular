package com.grandfrais.grandfrais.utils.MockBuilder;

import com.grandfrais.grandfrais.Domain.Departement;
import com.grandfrais.grandfrais.Domain.Personne;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartementMB {
    private Long id_dep;
    private String code;
    private String designation;
    private Personne personne;


    public DepartementMB setIdDep(Long id_dep){
        this.id_dep = id_dep;
        return this;
    }


    public DepartementMB setCode(String code){
        this.code = code ;
        return this;
    }


    public DepartementMB setDesignation(String designation){
        this.designation = designation;
        return this;
    }





    public Departement build(){
        Departement departement = mock(Departement.class);
        when(departement.getId()).thenReturn(this.id_dep);
        when(departement.getCode()).thenReturn(this.code);
        when(departement.getDesignation()).thenReturn(this.designation);


        return departement;

    }
}
