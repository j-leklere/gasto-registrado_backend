package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.BalanceDto;
import com.example.gastoregistrado.model.Balance;
import com.example.gastoregistrado.model.Expense;
import com.example.gastoregistrado.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/balances")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @GetMapping(value = "/getBalancesByUserId/{userId}")
    public ResponseEntity<List<Balance>> getBalancesByUser(@PathVariable Long userId) {
        List<Balance> balances = balanceService.getBalancesByUserId(userId);
        return ResponseEntity.ok(balances);
    }

    @GetMapping(value = "/getTotalBalancesByUserId/{userId}")
    public ResponseEntity<Number> getTotalBalancesByUser(@PathVariable Long userId) {
        Long totalBalances = balanceService.getTotalBalancesByUserId(userId);
        return ResponseEntity.ok(totalBalances);
    }

    @RequestMapping(value = "/createBalance", method = {RequestMethod.POST})
    public ResponseEntity<String> createBalance(@RequestBody BalanceDto balanceDto) {
        balanceService.createBalance(balanceDto);
        return ResponseEntity.status(HttpStatus.OK).body("Balance created successfully!");
    }

}
