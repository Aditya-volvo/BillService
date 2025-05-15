package com.example.billservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bill {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "gst")
    private double getGstInPercentage;

    @Column(name = "total_payable_amount")
    private double totalPayableAmount;

    @Column(name = "b_date_time")
    private LocalDateTime dateTime;

    @CollectionTable(name = "bill_transactions", joinColumns = @JoinColumn(name = "billId"))
    @Column(name = "transaction_Ids")
    private List<Long> transactionIds;  // OneToMany with TransactionService

    @Column(name = "patient_id")
    private  Long patientId; //ManyToOne with PatientService
}
