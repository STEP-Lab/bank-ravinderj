package com.step.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
  public AccountNumber(String number) throws InvalidAccountNumberException {
    Pattern regex = Pattern.compile("[\\d]{4}-[\\d]{4}");
    Matcher matcher = regex.matcher(number);
    if(!matcher.matches()) {
      throw new InvalidAccountNumberException();
    }
  }
}
