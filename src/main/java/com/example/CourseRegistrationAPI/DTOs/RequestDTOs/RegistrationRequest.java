package com.example.CourseRegistrationAPI.DTOs.RequestDTOs;

public record RegistrationRequest(String childName, int age,
                                  String courseSelected,
                                  String parentName,
                                  String parentEmail,
                                  String contactNumber) {
}
