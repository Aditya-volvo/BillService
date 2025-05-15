package com.example.billservice.service.serviceimpl;

import com.example.billservice.dto.BillRequest;
import com.example.billservice.dto.BillResponse;
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
        Bill bill = billRepository.findById(billId).orElseThrow();
        return globalResponseEntity.ok(bill);
    }

    @Override
    public List<BillResponse> getBillByPatientId(Long patientId) {
        List<Bill> bills = billRepository.findBillsByPatientsId(patientId) ;
        return bills.stream().map(globalMapper::mapRepositoryToResponse).toList();
    }
}
