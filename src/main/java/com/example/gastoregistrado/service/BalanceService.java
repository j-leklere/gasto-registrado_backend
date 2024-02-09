package com.example.gastoregistrado.service;


import com.example.gastoregistrado.dao.BalanceDao;
import com.example.gastoregistrado.dao.IncomeDao;
import com.example.gastoregistrado.dao.UserDao;
import com.example.gastoregistrado.dto.BalanceDto;
import com.example.gastoregistrado.model.Balance;
import com.example.gastoregistrado.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BalanceDao balanceDao;

    public void createBalance(BalanceDto balanceDto) {
        Balance balance = new Balance();

        balance.setName(balanceDto.getName());
        balance.setAmount(balanceDto.getAmount());
        balance.setCurrency(balanceDto.getCurrency());
        balance.setImageCover(balanceDto.getImageCover());
        balance.setType(balanceDto.getType());
        balance.setName(balanceDto.getName());

        User user = userDao.findById(balanceDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + balanceDto.getUserId()));
        balance.setUser(user);

        balance.onCreate();

        balanceDao.save(balance);
    }
}
