package com.example.billservice.response;

import com.example.billservice.dto.BillResponse;
import com.example.billservice.model.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GlobalResponseEntity {
    public ResponseEntity<BillResponse> mapEntityToResponseDto(Bill bill){
        return ResponseEntity.ok(
                new BillResponse(
                        bill.getBillId(),
                        bill.getTotalAmount(),
                        bill.getGetGstInPercentage(),
                        bill.getTotalPayableAmount(),
                        bill.getDateTime(),
                        bill.getTransactionIds(),
                        bill.getPatientId()
                ));
    }
}
