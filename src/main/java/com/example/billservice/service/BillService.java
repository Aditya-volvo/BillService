package com.example.billservice.service;

import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface BillService {
    ResponseEntity<BillResponse> generateBill(@Valid BillRequest billRequest);
}
