package com.step.bank;

public class Account {
  private float balance;

  public Account(AccountNumber accountNumber, float balance) throws MinimumBalanceException {
    if (balance < 1000) {
      throw new MinimumBalanceException();
    }
    this.balance = balance;
  }

  public float getBalance(){
    return balance;
  }

  public void withdraw(float amount) throws MinimumBalanceException {
    float balance = this.balance - amount;
    if (balance < 1000) {
     throw new MinimumBalanceException();
    }
    this.balance -= amount;
  }
}
