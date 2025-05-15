package com.example.billservice.mapper;

import com.example.billservice.dto.BillRequest;
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
}
