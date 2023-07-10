package com.towerbuilder.proposalsubmitter.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.towerbuilder.proposalsubmitter.model.Grade
import com.towerbuilder.proposalsubmitter.model.Status
import com.towerbuilder.proposalsubmitter.model.dao.Employee
import com.towerbuilder.proposalsubmitter.model.dto.ProposalDTO
import com.towerbuilder.proposalsubmitter.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification



// todo zaktualizuj intellij
import java.time.LocalDate

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
// tworzy beana mockmvc dzieki ktoremu mozna wysylac requesty na controllery
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
class ProposalControllerSpec extends Specification {
    // uzywanie w terstach autowired jest ok bo sa inaczej odpalane niz np serwisy
    // mockmvc mockuje postmana albo przegladarke i jest jedynym mockiem uzywanym do testow integracyjnych
    @Autowired
    MockMvc mockMvc
    @Autowired
    // mapuje obeikty javowe na jsony i odwrotnie
    ObjectMapper objectMapper
    @Autowired
    EmployeeRepository employeeRepository
    // na poczatek zawsze testuj happypath
    @WithMockUser
    def 'should save proposal'() {
        given:
        def employee = employeeRepository.save(new Employee(grade: Grade.F, email: "abc@test.com"))
        def proposalDTO = new ProposalDTO(firstDay: LocalDate.now(), lastDay: LocalDate.MAX)
        expect:
        // mockmvcrequestbuilder dlatego ze jestesmy  w metodzie w mockmvc i budujemy request
        mockMvc.perform(post("/api/v5/proposals/" + employee.getId())
                .contentType(MediaType.APPLICATION_JSON)
        // stworz ten proposaldto i sprawdz czy status w nim jest wgl potrzebny
                .content(objectMapper.writeValueAsString(proposalDTO)))
                .andExpect(status().isCreated())
        // wazne ze id jest to trzeba sprwdzic bo ja to pisaelm. jaka liczbe stasnowi id to nie ma znaczenia bo ustala to baza danych a nie ja
        .andExpect(jsonPath('$.id').exists())
        .andExpect(jsonPath('$.createdDate').exists())
        .andExpect(jsonPath('$.lastModifiedDate').exists())
        .andExpect(jsonPath('$.createdBy').exists())
        .andExpect(jsonPath('$.lastModifiedBy').exists())
        .andExpect(jsonPath('$.version').value(0))
        .andExpect(jsonPath('$.tripType').doesNotExist())
        .andExpect(jsonPath('$.firstDay').value(proposalDTO.firstDay.toString()))
        .andExpect(jsonPath('$.lastDay').value(proposalDTO.lastDay.toString()))
        .andExpect(jsonPath('$.country').doesNotExist())
        .andExpect(jsonPath('$.city').doesNotExist())
        .andExpect(jsonPath('$.isTripWithAccommodation').doesNotExist())
        .andExpect(jsonPath('$.status').value(Status.ACCEPTED.toString()))
        .andExpect(jsonPath('$.price').doesNotExist())
    }



    /*
    todo  wszystkie zadania
    - integracyjne i jednostkowe w spocku
    - Auditing
    - Cacheowanie danych
    - Generowanie plików i ich ściąganie w endpointach
    - wielowątkowosc
    - Wysyłanie maili z plikami i dorobić do tego templatey itp
    - Tranzakcyjność
    - bardziej zaawansowany mapstruct
    - Dokumentacja restowego api wymóg przed zrobieniem frontendu (1. do dependecji springdoc,
      2. odpal apke i wpisz link http://localhost:8080/swagger-ui/index.html#/,
      3. frontendowcy tego uzywaja zeby wygenerowac komunikacje z backendem)
    - dodali nową bibliotekę w springboocie ktora obsluguje graphql Graphql tzn zapytania grafowe gdzie mozna
      jednoczesnie wyslac kilka zapytan i dostane kilka odpowiedzi. wykonuje sie to wielowatkowo od reki bez watkow springowych


   - Front w angularze



    - MongoDb - moge sobie zrobic certyfikat za darmo



    - Grupy w validatorach -> włączanie/wyłączanie walidacji
    - mikroserwisy
    - baza nosqlowa
    - docker
    */
}

/*
Do przehowywania dokumentów w ktorcyh nie bede przechowywal zacnych relacji. jest szybszy
- tak mozna by to zrobic
- model noqlowy oznaczasz @document i id jest stringowe i samo sie nadaje
- trzeba dorzucic spring data mongodb
*/