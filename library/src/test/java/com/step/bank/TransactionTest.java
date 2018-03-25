package com.step.bank;

import com.step.bank.CreditTransaction;
import com.step.bank.DebitTransaction;
import com.step.bank.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void mustRecordCorrectDebitTransactionDate() {
    Date date = new Date();
    DebitTransaction debitTransaction = new DebitTransaction(date, 1000, "another_account");
    assertThat(debitTransaction.getDate(), is(date));
  }

  @Test
  public void mustRecordCorrectCreditTransactionDate() {
    Date date = new Date();
    CreditTransaction creditTransaction = new CreditTransaction(date, 1000, "another account");
    assertThat(creditTransaction.getDate(), is(date));
  }
}
