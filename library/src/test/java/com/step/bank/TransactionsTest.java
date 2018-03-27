package com.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
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

  @Test
  public void mustGetTransactionsBelowACertainAmount() {
    transactions.debit(700, "1234-5678");
    transactions.credit(800, "1234-1234");
    transactions.debit(1000, "1234-6789");
    transactions.credit(1100, "3456-7890");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(),700,"1234-5678");
    CreditTransaction creditTransaction = new CreditTransaction(new Date(),800,"1234-1234");
    assertThat(transactions.getBelow(1000).list, hasItems(debitTransaction,creditTransaction));
  }

  @Test
  public void mustGetAllCreditTransactions() {
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.credit(1500, "3456-7890");
    CreditTransaction creditTransaction = new CreditTransaction(new Date(),1000,"1234-1234");
    CreditTransaction creditTransaction2 = new CreditTransaction(new Date(),1500,"3456-7890");
    assertThat(transactions.getCreditTransactions().list, hasItems(creditTransaction,creditTransaction2));
  }

  @Test
  public void mustGetAllDebitTransactions() {
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.debit(1500, "3456-7890");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(), 1100, "1234-6789");
    DebitTransaction debitTransaction2 = new DebitTransaction(new Date(), 1500, "3456-7890");
    assertThat(transactions.getDebitTransactions().list, hasItems(debitTransaction,debitTransaction2));
  }

  @Test
  public void mustGetAllTransactionsAfterAParticularDate() {
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.debit(1500, "3456-7890");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(), 1100, "1234-6789");
    DebitTransaction debitTransaction2 = new DebitTransaction(new Date(), 1500, "3456-7890");
    assertThat(transactions.getTransactionsAfter(new Date(1)).list, hasItems(debitTransaction,debitTransaction2));
  }

  @Test
  public void mustGetAllTransactionsBeforeAParticularDate() {
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.debit(1500, "3456-7890");
    Date currentDate = new Date();
    DebitTransaction debitTransaction = new DebitTransaction(new Date(), 1100, "1234-6789");
    DebitTransaction debitTransaction2 = new DebitTransaction(new Date(), 1500, "3456-7890");
    assertThat(transactions.getTransactionsBefore(new Date(currentDate.getYear(),currentDate.getMonth(),currentDate.getDate()+1)).list, hasItems(debitTransaction,debitTransaction2));
  }

  @Test
  public void mustPrintAllTransactionsToAnOutputStream() throws FileNotFoundException, UnsupportedEncodingException {
    transactions.credit(1000, "1234-1234");
    transactions.debit(1100, "1234-6789");
    transactions.debit(1500, "3456-7890");
    DebitTransaction debitTransaction = new DebitTransaction(new Date(), 1100, "1234-6789");
    DebitTransaction debitTransaction2 = new DebitTransaction(new Date(), 1500, "3456-7890");
    CreditTransaction creditTransaction = new CreditTransaction(new Date(), 1000, "1234-1234");
    ArrayList<String> result = new ArrayList<>();
    PrintWriter printer = new PrintWriter("somefile", "utf8"){
      @Override
      public void println(String text){
        result.add(text);
      }
    };
    transactions.print(printer);
    printer.close();
    assertThat(result, hasItems(debitTransaction.toString(),debitTransaction2.toString(),creditTransaction.toString()));
  }

  @Test
  public void shouldWriteToCsvFile() throws FileNotFoundException, UnsupportedEncodingException {
    ArrayList<CharSequence> result = new ArrayList<>();
    transactions.debit(1000,"1234-1234");
    PrintWriter writer = new PrintWriter("transactions.csv", "utf8"){
      @Override
      public void println(String string) {
        result.add(string);
      }
    };
    transactions.printCsv(writer);
    assertThat(result,hasItems("date,amount,to",transactions.list.get(0).toCsv()));
  }
}
