package com.step.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
  private final String accountNumber;
  private float balance;

  public Account(String accountNumber, float balance) throws MinimumBalanceException, InvalidAccountNumberException {
    Pattern regex = Pattern.compile("[\\d]{4}-[\\d]{4}");
    Matcher matcher = regex.matcher(accountNumber);
    if(!matcher.matches()) {
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
    if (balance < 1000) {
      throw new MinimumBalanceException();
    }
    this.balance = balance;
  }

  public float getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
  public void withdraw(float amount) throws MinimumBalanceException {
    float balance = this.balance - amount;
    if (balance < 1000) {
     throw new MinimumBalanceException();
    }
    this.balance -= amount;
  }
}
