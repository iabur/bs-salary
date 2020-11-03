package com.bs23.esmpanel.controllers;

import com.bs23.esmpanel.request.PaymentRequest;
import com.bs23.esmpanel.request.RechargeBalanceRequest;
import com.bs23.esmpanel.service.BankAccountService;
import com.bs23.esmpanel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MoneyTransactionRESTController {

    private final BankAccountService bankAccountService;
    private final UserService userService;

    public MoneyTransactionRESTController(BankAccountService bankAccountService, UserService userService) {
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    @PostMapping("/recharge-money")
    public ResponseEntity<?> rechargeMoney(@RequestParam(name = "amount") long amount) {
        RechargeBalanceRequest request = new RechargeBalanceRequest();
        request.setCurrentBalance(bankAccountService.rechargeAmountOnCompany(amount));
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PostMapping("/pay-employee")
    public ResponseEntity<?> rechargeMoney(@RequestParam(name = "userId") String userId,
                                           @RequestParam(name = "amount") long amount) {
        PaymentRequest request = new PaymentRequest();

        request.setMsg(bankAccountService.paySalaryToAUser(userService.findById(Long.parseLong(userId)), amount));
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

}
