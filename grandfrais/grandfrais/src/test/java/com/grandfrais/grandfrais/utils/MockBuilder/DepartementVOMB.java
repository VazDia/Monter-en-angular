package com.grandfrais.grandfrais.utils.MockBuilder;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Application.PersonneVO;
import com.grandfrais.grandfrais.Domain.Departement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartementVOMB {
    private Long id_dep;
    private String code;
    private String designation;

    public DepartementVOMB setIdDep(Long id_dep){
        this.id_dep = id_dep;
        return this;
    }


    public DepartementVOMB setCode(String code){
        this.code = code ;
        return this;
    }


    public DepartementVOMB setDesignation(String designation){
        this.designation = designation;
        return this;
    }





    public DepartementVO build() {
        DepartementVO departementVo = mock(DepartementVO.class);
        when(departementVo.getId()).thenReturn(this.id_dep);
        when(departementVo.getCode()).thenReturn(this.code);
        when(departementVo.getDesignation()).thenReturn(this.designation);


        return departementVo;
    }
}
