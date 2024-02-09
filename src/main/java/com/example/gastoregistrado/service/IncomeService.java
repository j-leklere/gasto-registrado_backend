package com.example.gastoregistrado.service;

import com.example.gastoregistrado.dao.IncomeDao;
import com.example.gastoregistrado.dao.UserDao;
import com.example.gastoregistrado.dto.IncomeDto;
import com.example.gastoregistrado.model.Income;
import com.example.gastoregistrado.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private IncomeDao incomeDao;

    public void createIncome(IncomeDto incomeDto) {
        Income income = new Income();

        income.setName(incomeDto.getName());
        income.setAmount(incomeDto.getAmount());
        income.setCurrency(incomeDto.getCurrency());
        income.setExpireDate(incomeDto.getExpireDate());
        income.setDescription(incomeDto.getDescription());
        income.setImageCover(incomeDto.getImageCover());
        income.setTerm(incomeDto.getTerm());
        income.setState(incomeDto.getState());
        income.setType(incomeDto.getType());

        User user = userDao.findById(incomeDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + incomeDto.getUserId()));
        income.setUser(user);

        income.onCreate();

        incomeDao.save(income);
    }

    public List<Income> getIncomesByUserId(Long userId) {
        return incomeDao.findIncomesByUserId(userId);
    }
}
