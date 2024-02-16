package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.dto.CategoryTotalDto;
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

    @Query("SELECT new com.example.gastoregistrado.dto.CategoryTotalDto(e.category, SUM(e.amount)) FROM Expense e WHERE e.user.id = :userId GROUP BY e.category")
    List<CategoryTotalDto> findCategoryTotalExpensesByUserId(Long userId);

    @Query("SELECT DISTINCT e.category FROM Expense e WHERE e.user.id = :userId")
    List<Object[]> findExpensesCategoriesByUserId(Long userId);
}
