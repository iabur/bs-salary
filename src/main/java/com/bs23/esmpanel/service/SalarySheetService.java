package com.bs23.esmpanel.service;

import com.bs23.esmpanel.repositories.SalarySheetRepository;
import com.bs23.esmpanel.response.SalarySheetResponse;
import com.bs23.esmpanel.model.SalarySheet;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalarySheetService {

    private final SalarySheetRepository salarySheetRepository;

    @Autowired
    public SalarySheetService(SalarySheetRepository salarySheetRepository) {
        this.salarySheetRepository = salarySheetRepository;
    }

    public List<SalarySheetResponse> findByUsername(String username) {
        List<SalarySheetResponse> salarySheetList = new ArrayList<>();

        for (SalarySheet salarySheet :
                salarySheetRepository.findAllByUserUsername(username)) {
            SalarySheetResponse salarySheetResponse = new SalarySheetResponse();
            salarySheetResponse.setId(salarySheet.getId());
            salarySheetResponse.setPayDate(new PrettyTime().format(new Date(Timestamp.valueOf(salarySheet.getPay_date()).getTime())));
            salarySheetResponse.setUsername(salarySheet.getUser().getUsername());
            salarySheetResponse.setAmount(salarySheet.getAmount());
            salarySheetList.add(salarySheetResponse);
        }
        return salarySheetList;
    }

    public List<SalarySheetResponse> findAll() {
        List<SalarySheetResponse> salarySheetList = new ArrayList<>();
        for (SalarySheet salarySheet :
                salarySheetRepository.findAll()) {
            SalarySheetResponse salarySheetResponse = new SalarySheetResponse();
            salarySheetResponse.setId(salarySheet.getId());
            salarySheetResponse.setPayDate(new PrettyTime().format(new Date(Timestamp.valueOf(salarySheet.getPay_date()).getTime())));
            salarySheetResponse.setUsername(salarySheet.getUser().getUsername());
            salarySheetResponse.setAmount(salarySheet.getAmount());
            salarySheetList.add(salarySheetResponse);
        }
        return salarySheetList;
    }

    public long getTotalPaidAmount() {
        if (salarySheetRepository.sumOfPaidAmount().isEmpty()) {
            return 0;
        }
        return Long.parseLong(salarySheetRepository.sumOfPaidAmount().get().toString());
    }

    public void insertEntry(SalarySheet salarySheet) {
        salarySheetRepository.save(salarySheet);
    }


}
