package com.example.billservice.client;

import com.example.billservice.dto.TransactionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "transaction-service", url = "${transaction.service.url}")
public interface TransactionServiceClient {
    @GetMapping("/api/transactions/bill/{billId}")
    List<TransactionResponseDto> getTransactionsByBillId(@PathVariable("billId") Long billId);
}
