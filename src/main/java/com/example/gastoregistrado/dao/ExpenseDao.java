package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.dto.ExpenseDto;
import com.example.gastoregistrado.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {
    @Query("SELECT e FROM Expense e WHERE e.user.id = :userId")
    List<Expense> findExpensesByUserId(Long userId);
}
