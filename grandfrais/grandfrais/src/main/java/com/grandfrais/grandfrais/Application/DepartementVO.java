package com.grandfrais.grandfrais.Application;

import com.grandfrais.grandfrais.Domain.Departement;

public class DepartementVO {
    private Long id;
    private String code;
    private String designation;

    public DepartementVO() {}

    public DepartementVO(Departement departement) {
        this.id = departement.getId();
        this.code = departement.getCode();
        this.designation = departement.getDesignation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
