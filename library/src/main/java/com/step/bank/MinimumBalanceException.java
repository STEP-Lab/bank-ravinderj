package com.step.bank;

public class MinimumBalanceException extends Throwable {
  public MinimumBalanceException() {
    super("Insufficient minimum balance");
  }
}
