package com.grandfrais.grandfrais.Services;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Application.PersonneVO;
import com.grandfrais.grandfrais.Domain.Departement;
import com.grandfrais.grandfrais.Domain.Personne;
import com.grandfrais.grandfrais.Repository.DepartementRepository;
import com.grandfrais.grandfrais.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private DepartementRepository departementRepository;

    public PersonneVO create(PersonneVO personneVo) {
        if (personneVo.getDepartement() == null || personneVo.getDepartement().getId() == null) {
            throw new IllegalArgumentException("Identifiant du département manquant");
        }
        Departement departement = departementRepository.findById(personneVo.getDepartement().getId())
                .orElseThrow(() -> new IllegalArgumentException("Département introuvable"));
        if (departement == null) {
            throw new IllegalArgumentException("Département invalide");
        }
        Personne personne = new Personne(null, personneVo.getNom(), personneVo.getPrenoms(), personneVo.getAge(), departement);
        Personne savedPersonne = personneRepository.save(personne);
        return new PersonneVO(savedPersonne);
    }

    public PersonneVO getPersonneByIdWithDepartement(Long id) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La personne avec " + id + " est introuvable"));
        return new PersonneVO(personne);
    }

    public List<PersonneVO> findAll() {
        List<Personne> personnes = personneRepository.findAll();
        return personnes.stream().map(PersonneVO::new).collect(Collectors.toList());
    }

    public Optional<PersonneVO> findById(Long id) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        return personneOptional.map(PersonneVO::new);
    }

    public PersonneVO update(Long id, PersonneVO personneVo) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {
            Personne personne = personneOptional.get();
            Departement departement = departementRepository.findById(personneVo.getDepartement().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Département introuvable"));
            personne.setNom(personneVo.getNom());
            personne.setPremons(personneVo.getPrenoms());
            personne.setAge(personneVo.getAge());
            personne.setDepartement(departement);
            Personne updatedPersonne = personneRepository.save(personne);
            return new PersonneVO(updatedPersonne);
        }
        return null;
    }

    public void deleteById(Long id) {
        personneRepository.deleteById(id);
    }
}
