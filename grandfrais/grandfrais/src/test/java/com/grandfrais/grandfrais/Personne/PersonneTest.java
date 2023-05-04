package com.grandfrais.grandfrais.Personne;

import com.grandfrais.grandfrais.Application.DepartementVO;
import com.grandfrais.grandfrais.Application.PersonneVO;
import com.grandfrais.grandfrais.Domain.Departement;
import com.grandfrais.grandfrais.Domain.Personne;
import com.grandfrais.grandfrais.Repository.DepartementRepository;
import com.grandfrais.grandfrais.Repository.PersonneRepository;
import com.grandfrais.grandfrais.Services.PersonneService;
import com.grandfrais.grandfrais.utils.MockBuilder.DepartementMB;
import com.grandfrais.grandfrais.utils.MockBuilder.DepartementVOMB;
import com.grandfrais.grandfrais.utils.MockBuilder.PersonneMB;
import com.grandfrais.grandfrais.utils.MockBuilder.PersonneVOMB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonneTest {
    @Mock
    private PersonneRepository personneRepository;
    @Mock
    private DepartementRepository departementRepository;
    @InjectMocks
    private PersonneService personneService;

    long id_personne = 1L;
    long id_departement = 3L;

    Departement departement = new DepartementMB()
            .setIdDep(id_departement)
            .setCode("Abois210")
            .setDesignation("Aboisso")
            .build();
    DepartementVO departementVo = new DepartementVOMB()
            .setIdDep(id_departement)
            .setCode("Abois210")
            .setDesignation("Aboisso")
            .build();

    Personne Vaz = new PersonneMB()
            .setId(id_personne)
            .setNom("Vazoumana")
            .setPrenom("Diarrassouba")
            .setAge(27)
            .setDepartement(departement)
            .build();
    PersonneVO VazVo= new PersonneVOMB()
            .setId(id_personne)
            .setNom("Vazoumana")
            .setPrenom("Diarrassouba")
            .setAge(27)
            .setDepartement(departementVo)
            .build();

    Departement departementprime = new DepartementMB()
            .setIdDep(4L)
            .setCode("BonA001")
            .setDesignation("Bonoua")
            .build();
    Personne Aichou = new PersonneMB()
            .setId(2L)
            .setNom("Aïcha")
            .setPrenom("Diarrassouba")
            .setAge(22)
            .setDepartement(departementprime)
            .build();



    @Test
    @DisplayName("Test of persons list")
    public void ShouldReturnPersonsList(){
        // GIVEN
        List<Personne> ListPersons = new ArrayList<>();
        ListPersons.add(Aichou);
        ListPersons.add(Vaz);
        when(personneRepository.findAll()).thenReturn(ListPersons);

        // When
       List <PersonneVO> ListPersonneVo = personneService.findAll();

       // Then
        verify(personneRepository).findAll();
        assertEquals(ListPersons.size(),ListPersonneVo.size());
        assertNotNull(ListPersonneVo);

    }

    @Test
    @DisplayName("Test Get Person byId")
    public void shouldFindPersonById(){
        // GIVEN
        when(personneRepository.findById(id_personne)).thenReturn(Optional.of(Vaz));

        //WHEN
        Optional<PersonneVO> personneVo = personneService.findById(id_personne);

        // THEN
        verify(personneRepository).findById(1L);
        assertNotNull(personneVo);
        assertTrue(personneVo.isPresent());
    }

    @Test
    @DisplayName("Test Get Person byId with false id")
    public void shouldNotFindPersonById(){
        // GIVEN
        when(personneRepository.findById(id_personne)).thenReturn(Optional.empty());

        //WHEN
        Optional<PersonneVO> personneVo = personneService.findById(id_personne);

        // THEN
        verify(personneRepository).findById(1L);
        assertThat(personneVo).isEmpty();
    }


    @Test
    @DisplayName("Test Adding person details")
    public void shouldSavePersonneDetails(){
        // Given
        when(departementRepository.findById(id_departement)).thenReturn(Optional.of(departement));
        when(personneRepository.save(Mockito.any(Personne.class))).thenReturn(Vaz);

        // WHEN
        PersonneVO savePerson = personneService.create(VazVo);

        //THEN
        assertNotNull(savePerson);
        assertEquals(savePerson.getNom(),VazVo.getNom());
    }

    @Test
    @DisplayName("Test Update Person Details")
    public void shouldUpdatePersonneDetails(){
        // GIVEN
        when(personneRepository.findById(id_personne)).thenReturn(Optional.of(Vaz));
        when(personneRepository.save(Mockito.any(Personne.class))).thenReturn(Vaz);
        when(departementRepository.findById(id_departement)).thenReturn(Optional.of(departement));

        // WHEN
        PersonneVO updatePerson = personneService.update(id_personne,VazVo);

        // THEN
        assertNotNull(updatePerson);

    }

    @Test
    @DisplayName("Test Deleting Person Details")
    public void shouldDeletePersonneDetails(){
        // GIVEN
        doNothing().when(personneRepository).deleteById(id_personne);

        // WHEN
        personneService.deleteById(id_personne);

        // THEN
        verify(personneRepository).deleteById(id_personne);
    }
}
