package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceDao extends JpaRepository<Balance, Long> {

}
