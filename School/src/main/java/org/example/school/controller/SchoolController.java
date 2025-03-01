package org.example.school.controller;

import lombok.RequiredArgsConstructor;
import org.example.school.model.School;
import org.example.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;


    @GetMapping("/param")
    public ResponseEntity<School> getSchool(@RequestParam("address") String address){

        return ResponseEntity.ok(schoolService.getSchoolByAddress(address));
    }





}
