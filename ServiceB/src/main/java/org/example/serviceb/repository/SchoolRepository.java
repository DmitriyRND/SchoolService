package org.example.serviceb.repository;

import org.example.serviceb.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {


    School findByAddress(String address);
}
