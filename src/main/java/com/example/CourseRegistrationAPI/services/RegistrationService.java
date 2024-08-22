package com.example.CourseRegistrationAPI.services;

import com.example.CourseRegistrationAPI.DTOs.RequestDTOs.RegistrationRequest;
import com.example.CourseRegistrationAPI.DTOs.ResponseDTOs.RegistrationResponse;
import com.example.CourseRegistrationAPI.exceptions.RegistrationNotFoundException;
import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.repositories.RegistrationRepository;
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
  public RegistrationResponse getRegistrationById(Long id) {
    Registration registration = registrationRepository.findById(id)
        .orElseThrow(() -> new RegistrationNotFoundException("Registration with ID " + id + " not found"));
    return toResponseDto(registration);
  }

  public RegistrationResponse createRegistration(RegistrationRequest registrationRequest) {
    Registration registration = toEntity(registrationRequest);
    return toResponseDto(registrationRepository.save(registration));
  }

  public RegistrationResponse updateRegistration(Long id, RegistrationRequest requestDto) {
    Registration registration = registrationRepository.findById(id)
        .orElseThrow(() -> new RegistrationNotFoundException("Registration with ID " + id + " not found"));
    registration.setChildName(requestDto.childName());
    registration.setAge(requestDto.age());
    registration.setCourseSelected(requestDto.courseSelected());
    registration.setParentName(requestDto.parentName());
    registration.setParentEmail(requestDto.parentEmail());
    registration.setParentPhone(requestDto.contactNumber());
    registration = registrationRepository.save(registration);
    return toResponseDto(registration);
  }

  public void deleteRegistration(Long id) {
    Registration registration = registrationRepository.findById(id)
        .orElseThrow(() -> new RegistrationNotFoundException("Registration with ID " + id + " not found"));
    registrationRepository.delete(registration);
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
