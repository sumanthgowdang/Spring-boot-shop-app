package com.restapi.jsonschema.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.jsonschema.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { 
}
