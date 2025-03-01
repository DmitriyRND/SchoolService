package org.example.serviceb.controller;

import lombok.RequiredArgsConstructor;
import org.example.serviceb.model.School;
import org.example.serviceb.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;


    @GetMapping("/param")
    public ResponseEntity<School> getSchool(@RequestParam("address") String address) {
        return ResponseEntity.ok(schoolService.getSchoolByAddress(address));

    }
}
