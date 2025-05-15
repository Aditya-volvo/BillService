package com.example.billservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillResponse {
    private Long billId;

    private double totalAmount;

    private double getGstInPercentage;

    private double totalPayableAmount;

    private LocalDateTime dateTime;

    private List<Long> transactionIds;// OneToMany with TransactionService

    private  Long patientId;
}
