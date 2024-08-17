package com.example.CourseRegistrationAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String childName;
  private int age;
  private String courseSelected;
  private String parentName;
  private String parentEmail;
  private String parentPhone;

  public Registration(String childName, int age, String courseSelected, String parentName, String parentEmail, String parentPhone) {
    this.childName = childName;
    this.age = age;
    this.courseSelected = courseSelected;
    this.parentName = parentName;
    this.parentEmail = parentEmail;
    this.parentPhone = parentPhone;
  }

}
