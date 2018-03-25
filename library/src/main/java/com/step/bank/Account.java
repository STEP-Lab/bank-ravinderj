package com.step.bank;

public class Account {
  private final AccountNumber accountNumber;
  private float balance;

  public Account(AccountNumber accountNumber, float balance) throws MinimumBalanceException {
    this.accountNumber = accountNumber;
    checkMinimumBalance(balance);
    this.balance = balance;
  }

  public float getBalance(){
    return balance;
  }

  public void withdraw(float amount) throws MinimumBalanceException {
    float balance = this.balance - amount;
    checkMinimumBalance(balance);
    this.balance -= amount;
  }

  private void checkMinimumBalance(float balance) throws MinimumBalanceException {
    if (balance < 1000) {
     throw new MinimumBalanceException();
    }
  }
}
