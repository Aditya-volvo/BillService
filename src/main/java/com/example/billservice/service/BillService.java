package com.example.billservice.service;

import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.dto.TransactionResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillService {
    ResponseEntity<BillResponse> generateBill(@Valid BillRequest billRequest);

   List<BillResponse> getAllBill();

    ResponseEntity<BillResponse> getBillById(Long billId);

    List<BillResponse> getBillByPatientId(Long patientId);

    List<TransactionResponseDto> getListOfAllTransactionByBillId(Long billId);
}
