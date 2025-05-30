package com.example.billservice.controller;
import com.example.billservice.client.TransactionServiceClient;
import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.dto.TransactionResponseDto;
import com.example.billservice.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<BillResponse> generateBill(@Valid @RequestBody BillRequest billRequest) {
        return billService.generateBill(billRequest);
    }

    @GetMapping
    public List<BillResponse> getAllBill() {
        return billService.getAllBill();
    }

    @GetMapping("/{billId}")
    public ResponseEntity<BillResponse> getBillById(@PathVariable Long billId) {
        return billService.getBillById(billId);
    }

    @GetMapping("/patient/{patientId}")
    public List<BillResponse> getBillByPatientsId(@PathVariable Long patientId) {
        return billService.getBillByPatientId(patientId);
    }

    @GetMapping("/transactions/{billId}")
    public List<TransactionResponseDto> getListOfAllTransactionByBillId(@PathVariable Long billId) {
        return billService.getListOfAllTransactionByBillId(billId);
    }
}
