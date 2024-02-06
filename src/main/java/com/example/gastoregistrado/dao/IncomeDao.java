package com.example.gastoregistrado.dao;

import com.example.gastoregistrado.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long> {

}
