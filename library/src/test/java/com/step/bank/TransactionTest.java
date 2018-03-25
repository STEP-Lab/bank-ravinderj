package com.step.bank;


import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void mustRecordCorrectDebitTransactionDate() {
    Date date = new Date();
    DebitTransaction debitTransaction = new DebitTransaction(date, 1000, "1234-5678");
    assertThat(debitTransaction.getDate(), is(date));
  }

  @Test
  public void mustRecordCorrectCreditTransactionDate() {
    Date date = new Date();
    CreditTransaction creditTransaction = new CreditTransaction(date, 1000, "1234-5678");
    assertThat(creditTransaction.getDate(), is(date));
  }
}
