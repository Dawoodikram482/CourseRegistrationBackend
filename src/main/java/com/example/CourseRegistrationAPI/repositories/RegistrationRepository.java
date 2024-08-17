package com.example.CourseRegistrationAPI.repositories;

import com.example.CourseRegistrationAPI.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
