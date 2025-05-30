package com.example.billservice.service.serviceimpl;

import com.example.billservice.client.PatientServiceClient;
import com.example.billservice.client.TransactionServiceClient;
import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
import com.example.billservice.dto.TransactionResponseDto;
import com.example.billservice.exception.BillNotFoundException;
import com.example.billservice.mapper.GlobalMapper;
import com.example.billservice.model.Bill;
import com.example.billservice.repository.BillRepository;
import com.example.billservice.response.GlobalResponseEntity;
import com.example.billservice.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final GlobalMapper globalMapper;
    private final GlobalResponseEntity globalResponseEntity;
    private final PatientServiceClient patientServiceClient;
    private final TransactionServiceClient transactionServiceClient;

    @Override
    public ResponseEntity<BillResponse> generateBill(BillRequest billRequest) {
        Bill bill = globalMapper.mapDtoToEntity(billRequest);
        Bill saved = billRepository.save(bill);
        return globalResponseEntity.ok(saved);
    }

    @Override
    public List<BillResponse>  getAllBill() {
        List<Bill> bills = billRepository.findAll();
        return bills.stream().map(globalMapper::mapRepositoryToResponse).toList();

    }

    @Override
    public ResponseEntity<BillResponse> getBillById(Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(()-> new BillNotFoundException("Bill with Id:"+billId+"not found"));
        return globalResponseEntity.ok(bill);
    }

    @Override
    public List<BillResponse> getBillByPatientId(Long patientId) {
        // Check if the patient exists in the Patient Service
        patientServiceClient.getPatientById(patientId);
        List<Bill> bills = billRepository.findBillsByPatientsId(patientId) ;
        if(bills == null){
            throw new BillNotFoundException("Bill with patientId:"+patientId+"not Found");
        }
        return bills.stream().map(globalMapper::mapRepositoryToResponse).toList();
    }

    @Override
    public List<TransactionResponseDto> getListOfAllTransactionByBillId(Long billId) {
        // Check if the bill exists
        Bill bill = billRepository.findById(billId)
                .orElseThrow(()-> new BillNotFoundException("Bill with Id:"+billId+"not found"));
        // Fetch transactions related to the bill
        List<TransactionResponseDto> transactions = transactionServiceClient.getTransactionsByBillId(billId);
        return transactions;
    }
}
