package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.BalanceDto;
import com.example.gastoregistrado.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/balances")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;
    @RequestMapping(value = "/createBalance", method = {RequestMethod.POST})
    public ResponseEntity<String> createBalance(@RequestBody BalanceDto balanceDto) {
        balanceService.createBalance(balanceDto);
        return ResponseEntity.status(HttpStatus.OK).body("Balance created successfully!");
    }
}
