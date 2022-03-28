package com.bank.kata;

import com.bank.kata.exception.AccountException;
import com.bank.kata.model.Amount;
import com.bank.kata.service.Account;
import com.bank.kata.service.AccountImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class US2Stepdefs {

    Account accountTest;
    LocalDate localDate;
    Amount newAmount;
    Amount amountRetrieve;

    @BeforeEach
    public void init(){

        localDate = LocalDate.now();
    }

    @Given("I have an account with {int} euros")
    public void iHaveAnAccountWithEuros(double moneyInAccount) {
        accountTest = new AccountImpl();
        newAmount = new Amount(moneyInAccount);
        accountTest.makeDeposit(newAmount, localDate);
    }

    @When("I make a withdrawal of {int} euros")
    public void iMakeAWithdrawalOfEuros(double moneyRetrieve) throws AccountException {
        amountRetrieve = new Amount(moneyRetrieve);
        accountTest.makeWithdraw(amountRetrieve, localDate);
    }

    @Then("My retrieve balance should be {int} euros")
    public void myRetrieveBalanceShouldBeEuros(double amountDispo) {
        Assertions.assertEquals(amountDispo, accountTest.getAmountBalance().getAmount());
    }
}
