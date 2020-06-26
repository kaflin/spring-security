package com.codebysuraj.useraccountregistration.repository;

import com.codebysuraj.useraccountregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
