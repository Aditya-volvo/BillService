package com.example.billservice.service.serviceimpl;

import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.model.Bill;
import com.example.billservice.repository.BillRepository;
import com.example.billservice.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Override
    public ResponseEntity<BillResponse> generateBill(BillRequest billRequest) {
        Bill bill = Bill.builder()
                .totalAmount(billRequest.getTotalAmount())
                .getGstInPercentage(billRequest.getGetGstInPercentage())
                .totalPayableAmount(billRequest.getTotalPayableAmount())
                .dateTime(billRequest.getDateTime())
                .transactionIds(billRequest.getTransactionIds())
                .patientId(billRequest.getPatientId())
                .build();
        Bill saved = billRepository.save(bill);
        return ResponseEntity.ok(
                new BillResponse(
                        saved.getBillId(),
                        saved.getTotalAmount(),
                        saved.getGetGstInPercentage(),
                        saved.getTotalPayableAmount(),
                        saved.getDateTime(),
                        saved.getTransactionIds(),
                        saved.getPatientId()
                ));
    }
}
