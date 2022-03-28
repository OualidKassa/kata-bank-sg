package com.bank.kata;

import com.bank.kata.exception.AccountException;
import com.bank.kata.model.Amount;
import com.bank.kata.service.Account;
import com.bank.kata.service.AccountImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class US3Stepdefs {

    Account accountTest;
    Amount newAmount;

    @Given("I have an account without operations and with {int} euros")
    public void iHaveAnAccountWithoutOperationsAndWithEuros(double moneyInAccount) {
        newAmount = new Amount(moneyInAccount);
        accountTest = new AccountImpl();
        accountTest.makeDeposit(newAmount, LocalDate.now());
    }

    @When("I make two deposit of {int} and {int} euros and two withdraw of {int} and {int} euros")
    public void iMakeTwoDepositOfAndEurosAndTwoWithdrawOfAndEuros(double moneyDepot1, double moneyDepot2,
                                                                  double moneyRetrieve1, double moneyRetrieve2) throws AccountException {
        Amount amountDepositOne = new Amount(moneyDepot1);
        Amount amountDepositTwo = new Amount(moneyDepot2);
        Amount amountRetrieveOne = new Amount(moneyRetrieve1);
        Amount amountRetrieveTwo = new Amount(moneyRetrieve2);
        accountTest.makeDeposit(amountDepositOne, LocalDate.now());
        accountTest.makeDeposit(amountDepositTwo, LocalDate.now());
        accountTest.makeWithdraw(amountRetrieveOne, LocalDate.now());
        accountTest.makeWithdraw(amountRetrieveTwo, LocalDate.now());
    }

    @Then("My history should print operations and balance of {int} euros")
    public void myHistoryShouldPrintOperationsAndBalanceOfEuros(double moneyInBalance) {
        String expected = "[Operation(type=DEPOSIT, date="+LocalDate.now()+", balance=Amount(amount=1000.0))," +
                " Operation(type=DEPOSIT, date="+LocalDate.now()+", balance=Amount(amount=100.0))," +
                " Operation(type=DEPOSIT, date="+LocalDate.now()+", balance=Amount(amount=200.0))," +
                " Operation(type=WITHDRAW, date="+LocalDate.now()+", balance=Amount(amount=100.0))," +
                " Operation(type=WITHDRAW, date="+LocalDate.now()+", balance=Amount(amount=200.0))]";
        Assertions.assertEquals(moneyInBalance,accountTest.getAmountBalance().getAmount());
        Assertions.assertEquals(expected, accountTest.printHistoryOperation());
    }
}
