package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceDao extends JpaRepository<Balance, Long> {
    @Query("SELECT b FROM Balance b WHERE b.user.id = :userId")
    List<Balance> findBalancesByUserId(Long userId);
}
