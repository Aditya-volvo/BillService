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
        return globalResponseEntity.mapEntityToResponseDto(saved);
    }
}
