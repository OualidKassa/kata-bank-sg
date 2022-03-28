package com.bank.kata.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Operation {
    private final OperationType type;
    private final LocalDate date;
    private final Amount balance;
}
