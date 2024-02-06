package com.example.gastoregistrado.service;

import com.example.gastoregistrado.dao.ExpenseDao;
import com.example.gastoregistrado.dao.UserDao;
import com.example.gastoregistrado.dto.ExpenseDto;
import com.example.gastoregistrado.dto.UserDto;
import com.example.gastoregistrado.model.Expense;
import com.example.gastoregistrado.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    ExpenseDao expenseDao;

    @Autowired
    UserDao userDao;

    public void createExpense(ExpenseDto expenseDto, Long userId) {
        Expense expense = new Expense();

        expense.setName(expenseDto.getName());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setCurrency(expenseDto.getCurrency());
        expense.setExpireDate(expenseDto.getExpireDate());
        expense.setDescription(expenseDto.getDescription());
        expense.setImageCover(expenseDto.getImageCover());
        expense.setTerm(expenseDto.getTerm());
        expense.setState(expenseDto.getState());
        expense.setType(expenseDto.getType());

        User user = userDao.findById(expenseDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + expenseDto.getUserId()));
        expense.setUser(user);

        expense.onCreate();

        expenseDao.save(expense);
    }
}
