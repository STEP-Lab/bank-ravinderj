package com.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
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
    transactions.credit(1000, "1234-5678");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(),1000,"1234-5678");
    CreditTransaction creditTransaction = new CreditTransaction(new Date(),1000,"1234-5678");
    assertThat(transactions.list,hasItems(debitTransaction, creditTransaction));
  }

  @Test
  public void mustGetTransactionsAboveACertainAmount() {
    transactions.debit(1200, "1234-5678");
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.credit(1500, "3456-7890");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(),1200,"1234-5678");
    DebitTransaction debitTransaction2 = new DebitTransaction(new Date(),1100,"1234-6789");
    CreditTransaction creditTransaction = new CreditTransaction(new Date(),1500,"3456-7890");
    assertThat(transactions.getAbove(1000).list, hasItems(debitTransaction,debitTransaction2,creditTransaction));
  }
}
