package com.bank.kata.service;

import com.bank.kata.model.Operation;

import java.util.List;

public interface OperationHistory {
    void addOperation (Operation operation);
     List<Operation> getOperations();
}
