package com.example.CourseRegistrationAPI.services;

import com.example.CourseRegistrationAPI.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
  @Autowired
  RegistrationRepository registrationRepository;
}
