package com.example.billservice.dto;

import lombok.Data;

@Data
public class PatientResponseDto {
    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String patientPhoneNumber;
}
