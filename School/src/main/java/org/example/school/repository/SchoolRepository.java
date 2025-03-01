package org.example.school.repository;

import org.example.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {

    Optional<School> findByAddress(String address);
}
