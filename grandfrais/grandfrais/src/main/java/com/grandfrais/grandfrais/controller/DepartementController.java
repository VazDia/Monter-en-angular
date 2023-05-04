package com.grandfrais.grandfrais.controller;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    @Autowired
    private DepartementService departementService;
    @GetMapping("getAll")
    public List<DepartementVO> findAll(){
        return departementService.findAll();
    }
}
