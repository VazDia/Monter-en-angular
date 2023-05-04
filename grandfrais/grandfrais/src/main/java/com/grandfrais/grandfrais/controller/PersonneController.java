package com.grandfrais.grandfrais.controller;

import com.grandfrais.grandfrais.Application.PersonneVO;
import com.grandfrais.grandfrais.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
    @Autowired
    private PersonneService personneService;
    @PostMapping("create")
    public PersonneVO create(@RequestBody PersonneVO personneVo) {
        return personneService.create(personneVo);
    }
    @GetMapping("getAll")
    public List<PersonneVO> findAll() {
        return personneService.findAll();
    }
    @GetMapping("getById/{id}")
    public Optional<PersonneVO> findById(@PathVariable Long id) {
        return personneService.findById(id);
    }
    @PutMapping("update/{id}")
    public PersonneVO update(@PathVariable Long id, @RequestBody PersonneVO personneVo) {
        return personneService.update(id, personneVo);
    }
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        personneService.deleteById(id);
    }
}
