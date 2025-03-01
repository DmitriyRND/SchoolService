package org.example.serviceb.service;

import lombok.RequiredArgsConstructor;
import org.example.serviceb.model.School;
import org.example.serviceb.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    public School findSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School getSchoolByAddress(String address) {

        School schoolAddress = schoolRepository.findByAddress(address);
//        if (SchoolAddress.isPresent()) {
//            return SchoolAddress.get();
//        }
        return schoolAddress;
    }
}
