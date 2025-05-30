package com.example.billservice.client;

import com.example.billservice.dto.PatientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url = "${patient.service.url}")
public interface PatientServiceClient {
    @GetMapping("/api/patients/{patientId}")
    PatientResponseDto getPatientById(@PathVariable Long patientId);
}
