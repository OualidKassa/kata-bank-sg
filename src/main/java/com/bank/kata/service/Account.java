package com.bank.kata.service;

import com.bank.kata.exception.AccountException;
import com.bank.kata.model.Amount;

import java.time.LocalDate;

public interface Account {
    void makeDeposit(Amount amount, LocalDate localDate);
    void makeWithdraw(Amount amount, LocalDate localDate) throws AccountException;
    Amount getAmountBalance();
    String printHistoryOperation();
}
