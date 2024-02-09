package com.example.gastoregistrado.controller;

import com.example.gastoregistrado.dto.ExpenseDto;
import com.example.gastoregistrado.model.Expense;
import com.example.gastoregistrado.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "/getExpensesByUserId/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUser(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.getExpensesByUserId(userId);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping(value = "/getTotalExpensesByUserId/{userId}")
    public ResponseEntity<Number> getTotalExpensesByUser(@PathVariable Long userId) {
        Long totalExpenses = expenseService.getTotalExpensesByUserId(userId);
        return ResponseEntity.ok(totalExpenses);
    }


    @RequestMapping(value = "/createExpense", method = {RequestMethod.POST})
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDto expenseDto) {
        expenseService.createExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.OK).body("Expense created successfully!");
    }

    @RequestMapping(value = "/editExpense/{expenseId}", method = {RequestMethod.PATCH})
    public ResponseEntity<?> editExpense(@PathVariable Long expenseId, @RequestBody ExpenseDto expenseDto) {
        expenseService.editExpense(expenseId, expenseDto);
        return ResponseEntity.status(HttpStatus.OK).body("Expense edited successfully!");

    }

}
