package com.example.billservice.mapper;

import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class GlobalMapper {
    public Bill mapDtoToEntity(BillRequest billRequest){
        return Bill.builder()
                .totalAmount(billRequest.getTotalAmount())
                .getGstInPercentage(billRequest.getGetGstInPercentage())
                .totalPayableAmount(billRequest.getTotalPayableAmount())
                .dateTime(billRequest.getDateTime())
                .transactionIds(billRequest.getTransactionIds())
                .patientId(billRequest.getPatientId())
                .build();
    }

    public BillResponse mapRepositoryToResponse(Bill bill) {
        return BillResponse.builder()
                .billId(bill.getBillId())
                .totalAmount(bill.getTotalAmount())
                .getGstInPercentage(bill.getGetGstInPercentage())
                .totalPayableAmount(bill.getTotalPayableAmount())
                .dateTime(bill.getDateTime())
                .transactionIds(bill.getTransactionIds())
                .patientId(bill.getPatientId())
                .build();
    }
}
