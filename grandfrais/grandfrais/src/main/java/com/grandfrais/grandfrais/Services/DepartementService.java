package com.grandfrais.grandfrais.Services;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Domain.Departement;
import com.grandfrais.grandfrais.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public List<DepartementVO> findAll(){
        List<Departement> departements = departementRepository.findAll();
        return departements.stream()
                .map(departement -> {
                    DepartementVO departementVo = new DepartementVO();
                    departementVo.setId(departement.getId());
                    departementVo.setCode(departement.getCode());
                    departementVo.setDesignation(departement.getDesignation());
                    return departementVo;
                })
                .collect(toList());
    }
}
