package com.example.CourseRegistrationAPI.controllers;

import com.example.CourseRegistrationAPI.DTOs.RequestDTOs.RegistrationRequest;
import com.example.CourseRegistrationAPI.DTOs.ResponseDTOs.RegistrationResponse;
import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.services.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
  private final RegistrationService registrationService;

  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }
  @GetMapping
  public ResponseEntity<List<RegistrationResponse>> getAllRegistrations() {
    return ResponseEntity.ok(registrationService.getAllRegistrations());
  }
  @PostMapping
  public ResponseEntity<RegistrationResponse> createRegistration(@RequestBody RegistrationRequest registrationRequest) {
    return ResponseEntity.status(201).body(registrationService.createRegistration(registrationRequest));
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
    registrationService.deleteRegistration(id);
    return ResponseEntity.noContent().build();
  }
  @PutMapping("/{id}")
  public ResponseEntity<RegistrationResponse> updateRegistration(@PathVariable Long id, @RequestBody RegistrationRequest requestDto) {
    return ResponseEntity.ok(registrationService.updateRegistration(id, requestDto));
  }

}
