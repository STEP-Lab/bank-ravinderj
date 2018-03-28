package com.step.bank;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
    account = new Account(new AccountNumber("1234-5678"), 1000);
  }

  @Test
  public void checkBalance() {
    assertThat(account.getBalance(), is(Money.of(CurrencyUnit.of("INR"), 1000)));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    Account account = new Account(new AccountNumber("1234-5678"), 500);
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkInvalidAccountNumberValidity() throws MinimumBalanceException, InvalidAccountNumberException {
    Account account1 = new Account(new AccountNumber("1234"), 500);
    Account account2 = new Account(new AccountNumber("12345678"), 500); // not working
    Account account3 = new Account(new AccountNumber("12-34"), 500); // not working
    Account account4 = new Account(new AccountNumber("1234-56789"), 500); // not working
  }

  @Test
  public void checkWithdrawal() throws MinimumBalanceException, InvalidAccountNumberException {
    Account account = new Account(new AccountNumber("1234-5678"), 1500);
    account.withdraw(500);
    assertThat(account.getBalance(),is(Money.of(CurrencyUnit.of("INR"), 1000)));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkWithdrawalFromMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    Account account = new Account(new AccountNumber("1234-5678"), 1000);
    account.withdraw(500);
  }
}
