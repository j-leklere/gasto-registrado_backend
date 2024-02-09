package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long> {
    @Query("SELECT i FROM Income i WHERE i.user.id = :userId")
    List<Income> findIncomesByUserId(Long userId);

    @Query("SELECT i FROM Income i WHERE i.user.id = :userId AND i.term = 'monthly' AND i.state = 'active'")
    List<Income> findMonthlyIncomesByUserId(Long userId);
}
