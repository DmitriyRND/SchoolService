package org.example.school.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.school.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@AllArgsConstructor

@Data
public class ServiceBClient {
    @Autowired
    private  RestTemplate restTemplate;
    private String uri = "http://localhost:8081/service";

    public School getSchool(String address){
        System.out.println(address);

        School forEntity = restTemplate.getForObject(uri + "/param?address=" + address, School.class);
        System.out.println(forEntity);
        return forEntity;

    }
}
