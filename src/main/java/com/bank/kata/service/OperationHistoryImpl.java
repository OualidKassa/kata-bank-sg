package com.bank.kata.service;

import com.bank.kata.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationHistoryImpl implements OperationHistory{

    private final List<Operation> operations;

    public OperationHistoryImpl() {
        this.operations = new ArrayList<>();
    }

    @Override
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }
}
