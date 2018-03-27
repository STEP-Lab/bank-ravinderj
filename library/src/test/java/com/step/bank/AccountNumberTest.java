package com.step.bank;

import org.junit.Test;

public class AccountNumberTest {
  @Test
  public void validAccountNumberShouldBeCreated() throws InvalidAccountNumberException {
    new AccountNumber("1234-5678");
  }
  @Test(expected = InvalidAccountNumberException.class)
  public void invalidAccountNumberShouldNotBeCreated() throws InvalidAccountNumberException {
    new AccountNumber("1234-324");
  }
  @Test(expected = InvalidAccountNumberException.class)
  public void accountNumberShouldNotBeCreatedIfAlphaNumeric() throws InvalidAccountNumberException {
    new AccountNumber("1234-abcd");
  }
}