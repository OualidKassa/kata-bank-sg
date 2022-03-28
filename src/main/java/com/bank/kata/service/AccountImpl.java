package com.bank.kata.service;

import com.bank.kata.exception.AccountException;
import com.bank.kata.model.Amount;
import com.bank.kata.model.Operation;
import com.bank.kata.model.OperationType;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AccountImpl implements Account{

    private final  OperationHistory operationsHistory = new OperationHistoryImpl();
    private Amount balance = new Amount(0);

    private void addOperationToHistory(Amount amount, LocalDate localDate, OperationType deposit) {
        Operation operation = new Operation(deposit, localDate, amount);
        operationsHistory.addOperation(operation);
    }


    @Override
    public void makeDeposit(Amount amount, LocalDate localDate) {
        balance = balance.add(amount);
        addOperationToHistory(amount, localDate, OperationType.DEPOSIT);
    }

    @Override
    public void makeWithdraw(Amount amount, LocalDate localDate) throws AccountException {
        Amount resultingBalance = balance.subtract(amount);

        if (resultingBalance.isNegative()){
            throw new AccountException("Can't withdraw amount "+ amount + ". Balance is not enough!");
        }

        balance = resultingBalance;
        addOperationToHistory(amount, localDate, OperationType.WITHDRAW);
    }

    @Override
    public Amount getAmountBalance() {
        return balance;
    }

    @Override
    public String printHistoryOperation() {
       return   operationsHistory.getOperations().stream().toList().toString();
    }
}
