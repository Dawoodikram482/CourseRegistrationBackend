package com.example.CourseRegistrationAPI.services;

import com.example.CourseRegistrationAPI.DTOs.RequestDTOs.RegistrationRequest;
import com.example.CourseRegistrationAPI.DTOs.ResponseDTOs.RegistrationResponse;
import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
  private final RegistrationRepository registrationRepository;

  public RegistrationService(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  public List<RegistrationResponse> getAllRegistrations() {
    return registrationRepository.findAll().stream()
        .map(this::toResponseDto)
        .collect(Collectors.toList());
  }
  public RegistrationResponse createRegistration(RegistrationRequest registrationRequest) {
    Registration registration = toEntity(registrationRequest);
    return toResponseDto(registrationRepository.save(registration));
  }
  public void deleteRegistration(Long id) {
    registrationRepository.deleteById(id);
  }

  private Registration toEntity(RegistrationRequest dto) {
    Registration registration = new Registration();
    registration.setChildName(dto.childName());
    registration.setAge(dto.age());
    registration.setCourseSelected(dto.courseSelected());
    registration.setParentName(dto.parentName());
    registration.setParentEmail(dto.parentEmail());
    registration.setParentPhone(dto.contactNumber());
    return registration;
  }

  private RegistrationResponse toResponseDto(Registration registration) {
    return new RegistrationResponse(
        registration.getId(),
        registration.getChildName(),
        registration.getAge(),
        registration.getCourseSelected(),
        registration.getParentName(),
        registration.getParentEmail(),
        registration.getParentPhone()
    );
  }

}
