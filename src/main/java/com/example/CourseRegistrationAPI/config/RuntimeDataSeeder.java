package com.example.CourseRegistrationAPI.config;

import com.example.CourseRegistrationAPI.models.Registration;
import com.example.CourseRegistrationAPI.repositories.RegistrationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuntimeDataSeeder implements ApplicationRunner {
  private final RegistrationRepository registrationRepository;
  public RuntimeDataSeeder(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }
  @Override
  public void run(ApplicationArguments args) throws Exception {
    Registration registration = new Registration();
    registration.setChildName("John Doe");
    registration.setAge(10);
    registration.setCourseSelected("Mathematics");
    registration.setParentName("Jane Doe");
    registration.setParentEmail("jane@doe.com");
    registration.setParentPhone("1234567890");
    registrationRepository.save(registration);

    Registration registration2 = new Registration();
    registration2.setChildName("Jane Yo");
    registration2.setAge(12);
    registration2.setCourseSelected("Science");
    registration2.setParentName("John Yo");
    registration2.setParentEmail("john@yo.com");
    registration2.setParentPhone("0987654321");
    registrationRepository.save(registration2);
  }
}
