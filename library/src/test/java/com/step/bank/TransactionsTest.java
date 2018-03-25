package com.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() {
    transactions = new Transactions();
  }

  @Test
  public void mustRecordDebitTransaction() {
    transactions.debit(1000, "1234-5678");
    assertThat(transactions.list,hasItem(new DebitTransaction(new Date(),1000,"1234-5678")));
  }

  @Test
  public void mustRecordCreditTransaction() {
    transactions.credit(1000, "1234-5678");
    assertThat(transactions.list,hasItem(new CreditTransaction(new Date(),1000,"1234-5678")));
  }

  @Test
  public void mustRecordBothCreditAndDebitTransactions() {
    transactions.debit(1000, "1234-5678");
    assertThat(transactions.list,hasItem(new DebitTransaction(new Date(),1000,"1234-5678")));
    transactions.credit(1000, "1234-5678");
    assertThat(transactions.list,hasItem(new CreditTransaction(new Date(),1000,"1234-5678")));
  }
}
