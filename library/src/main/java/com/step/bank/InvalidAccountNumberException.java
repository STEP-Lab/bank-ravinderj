package com.step.bank;

public class InvalidAccountNumberException extends Throwable {
  public InvalidAccountNumberException() {
    super("Account Number is invalid");
  }
}
