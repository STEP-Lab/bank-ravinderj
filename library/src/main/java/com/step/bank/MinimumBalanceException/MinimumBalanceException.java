package com.step.bank.MinimumBalanceException;

public class MinimumBalanceException extends Throwable {
  public MinimumBalanceException() {
    super("Insufficient minimum balance");
  }
}
