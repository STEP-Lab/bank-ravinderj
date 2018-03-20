package com.step.bank.InvalidAccountNumberException;

public class InvalidAccountNumberException extends Throwable {
  public InvalidAccountNumberException() {
    super("Account Number is invalid");
  }
}
