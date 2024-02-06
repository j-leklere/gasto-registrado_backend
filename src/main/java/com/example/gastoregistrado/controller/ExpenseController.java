package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.ExpenseDto;
import com.example.gastoregistrado.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(value = "/createExpense", method = {RequestMethod.POST})
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDto expenseDto, Long userId) {
        expenseService.createExpense(expenseDto, userId);
        return ResponseEntity.status(HttpStatus.OK).body("Expense created succesfully!");
    }
}
