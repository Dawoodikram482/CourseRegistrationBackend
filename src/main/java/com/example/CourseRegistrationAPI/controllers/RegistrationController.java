package com.example.CourseRegistrationAPI.controllers;

import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.services.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
  private final RegistrationService registrationService;

  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }
  @GetMapping
  public ResponseEntity<List<Registration>> getAllRegistrations() {
    return ResponseEntity.ok(registrationService.getAllRegistrations());
  }
}
