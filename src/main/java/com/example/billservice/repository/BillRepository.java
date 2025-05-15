package com.example.billservice.repository;

import com.example.billservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {
    List<Bill> findBillsByPatientsId(Long patientId);
}
