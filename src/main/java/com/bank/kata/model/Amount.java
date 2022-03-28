package com.bank.kata.model;

import lombok.Data;

@Data
public class Amount {
    final double amount;

    public Amount(double amount) {
        this.amount = amount;
    }

    public Amount add(Amount toBeAdded){
        return new Amount(amount + toBeAdded.amount);
    }

    public Amount subtract(Amount toBeSubtracted){
        return new Amount(amount - toBeSubtracted.amount);
    }

    public boolean isNegative(){
        return amount<0;
    }
}
