package com.example.CourseRegistrationAPI.DTOs.ResponseDTOs;

public record RegistrationResponse(Long id,
                                   String childName,
                                   int age,
                                   String courseSelected,
                                   String parentName,
                                   String parentEmail,
                                   String contactNumber) {
}
