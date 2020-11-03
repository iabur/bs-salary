package com.bs23.esmpanel.controllers;

import com.bs23.esmpanel.service.BankAccountService;
import com.bs23.esmpanel.service.BaseService;
import com.bs23.esmpanel.service.SalarySheetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalarySheetController extends BaseService {

    final BankAccountService bankAccountService;
    final SalarySheetService salarySheetService;

    public SalarySheetController(BankAccountService bankAccountService, SalarySheetService salarySheetService) {
        this.bankAccountService = bankAccountService;
        this.salarySheetService = salarySheetService;
    }

    @GetMapping("/salary-sheet")
    public String showAllSalarySheet(Model model) {
        model.addAttribute("pageTitle", "Salary Sheet");
        model.addAttribute("authUser", getLoggedInUser());
        model.addAttribute("balance", bankAccountService.getBankBalanceByUsername(getLoggedInUser().getUsername()));
        if (getLoggedInUser().getUsername().equals("admin")) {
            model.addAttribute("salarysheets", salarySheetService.findAll());
        } else {
            model.addAttribute("salarysheetsMy", salarySheetService.findByUsername(getLoggedInUser().getUsername()));
        }
        return "salarysheet/show-all";
    }

}
