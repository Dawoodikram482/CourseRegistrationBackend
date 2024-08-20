package com.example.CourseRegistrationAPI.services;

import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
  private final RegistrationRepository registrationRepository;

  public RegistrationService(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  public List<Registration> getAllRegistrations() {
    return registrationRepository.findAll();
  }
}
