package com.example.billservice.dto;

import lombok.Data;

@Data
public class TransactionResponseDto {

    private Long transactionId;
    private String transactionType;
    private Double amount;
    private String status;
    private Long billId;

    // Additional fields can be added as needed
}
