package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {

}
