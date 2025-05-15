package com.example.billservice.controller;
import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    public ResponseEntity<BillResponse> generateBill(@Valid @RequestBody BillRequest billRequest){
       return billService.generateBill(billRequest);
    }
}
