package com.example.billservice.dto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequest {
    @NotBlank
    @PositiveOrZero
    private double totalAmount;
    @NotBlank
    @PositiveOrZero
    private double getGstInPercentage;
    @NotBlank
    @PositiveOrZero
    private double totalPayableAmount;
    @NotNull
    private LocalDateTime dateTime;
    @NotEmpty
    private List<@NotBlank Long> transactionIds;// OneToMany with TransactionService
    @NotBlank
    private  Long patientId;
}
