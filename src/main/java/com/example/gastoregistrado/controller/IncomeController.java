package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.IncomeDto;
import com.example.gastoregistrado.model.Income;
import com.example.gastoregistrado.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/incomes")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping("/getIncomesByUserId/{userId}")
    public ResponseEntity<List<Income>> getIncomesByUser(@PathVariable Long userId) {
        List<Income> incomes = incomeService.getIncomesByUserId(userId);
        return ResponseEntity.ok(incomes);
    }

    @GetMapping("/getMonthlyIncomesByUserId/{userId}")
    public ResponseEntity<List<Income>> getMonthlyIncomesByUser(@PathVariable Long userId) {
        List<Income> monthlyIncomes = incomeService.getMonthlyIncomesByUserId(userId);
        return ResponseEntity.ok(monthlyIncomes);
    }

    @GetMapping("/getTotalMonthlyIncomesByUserId/{userId}")
    public ResponseEntity<Number> getTotalMonthlyIncomesByUser(@PathVariable Long userId) {
        Long totalMonthlyIncomes = incomeService.getTotalMonthlyIncomesByUserId(userId);
        return ResponseEntity.ok(totalMonthlyIncomes);
    }


    @RequestMapping(value = "/createIncome", method = {RequestMethod.POST})
    public ResponseEntity<String> createIncome(@RequestBody IncomeDto incomeDto) {
        incomeService.createIncome(incomeDto);
        return ResponseEntity.status(HttpStatus.OK).body("Income created successfully!");
    }
}
