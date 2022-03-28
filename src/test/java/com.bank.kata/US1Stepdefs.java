package com.bank.kata;

import com.bank.kata.model.Amount;
import com.bank.kata.service.Account;
import com.bank.kata.service.AccountImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class US1Stepdefs {

    Account accountTest;
    LocalDate localDate;
    Amount newAmount;

    @BeforeEach
    public void init(){

        localDate = LocalDate.now();
    }

    @Given("I have an account")
    public void iHaveAnAccount() {
        accountTest = new AccountImpl();
    }

    @When("I make a deposit of {int} euros")
    public void iMakeADepositOfEuros(double deposit) {
         newAmount = new Amount(deposit);
        accountTest.makeDeposit(newAmount, localDate);
    }

    @Then("My balance should be {int} euros")
    public void myBalanceShouldBeEuros(double deposit) {
        Assertions.assertEquals(deposit, accountTest.getAmountBalance().getAmount());
    }
}
