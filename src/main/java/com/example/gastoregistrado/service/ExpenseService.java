package com.example.gastoregistrado.service;

import com.example.gastoregistrado.dao.ExpenseDao;
import com.example.gastoregistrado.dao.UserDao;
import com.example.gastoregistrado.dto.CategoryTotalDto;
import com.example.gastoregistrado.dto.ExpenseDto;
import com.example.gastoregistrado.model.Expense;
import com.example.gastoregistrado.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseDao expenseDao;

    @Autowired
    UserDao userDao;

    private ExpenseDto getExpenseDtoByExpense(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setId(expense.getId());
        expenseDto.setName(expense.getName());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setCategory(expense.getCategory());
        expenseDto.setCurrency(expense.getCurrency());
        expenseDto.setTerm(expense.getTerm());
        expenseDto.setType(expense.getType());

        return expenseDto;
    }

    private Expense copyProperties(ExpenseDto expenseDto, Expense expense) {
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

        return expense;
    }

    public void createExpense(ExpenseDto expenseDto) {
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

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseDao.findExpensesByUserId(userId);
    }

    public Long getTotalExpensesByUserId(Long userId) {
        List<Expense> userExpenses = expenseDao.findExpensesByUserId(userId);

        return userExpenses.stream()
                .mapToLong(Expense::getAmount)
                .sum();
    }

    public void editExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = copyProperties(expenseDto, expenseDao.findById(expenseId).get());

        expenseDao.save(expense);
    }

    public List<CategoryTotalDto> getTotalCategoryExpensesByUserId(Long userId) {
        return expenseDao.findCategoryTotalExpensesByUserId(userId);
    }

    public List<Object[]> getExpensesCategoriesByUserId(Long userId) {
        return expenseDao.findExpensesCategoriesByUserId(userId);
    }
}
