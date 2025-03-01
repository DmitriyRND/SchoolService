package org.example.school.service;

import lombok.RequiredArgsConstructor;
import org.example.school.client.ServiceBClient;
import org.example.school.model.School;
import org.example.school.repository.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final ServiceBClient serviceBClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }
    public List<School> getAllSchool(){
        return schoolRepository.findAll();
    }

    public School findSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }
    public School getSchoolByAddress(String address){

        Optional<School> SchoolAddress = schoolRepository.findByAddress(address);
        if(SchoolAddress.isPresent()){
            return SchoolAddress.get();
        }
        School school = serviceBClient.getSchool(address);
        if (school == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Школа не найдена");
        }
        School newSchool = new School();
        newSchool.setNumberSchool(school.getNumberSchool());
        newSchool.setAddress(school.getAddress());
        saveSchool(newSchool);
        return newSchool;
    }


}
