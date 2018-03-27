package com.step.bank;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
  public ArrayList<Transaction> list;

  Transactions() {
    this.list = new ArrayList<>();
  }
  public void debit(float amount, String account) {
    this.list.add(new DebitTransaction(amount, account));
  }

  public void credit(float amount, String account) {
    this.list.add(new CreditTransaction(amount, account));
  }

  public Transactions getAbove(float amount) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction.getAmount() > amount) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getBelow(float amount) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction.getAmount() < amount) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getCreditTransactions() {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction instanceof CreditTransaction) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getDebitTransactions() {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction instanceof DebitTransaction) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getTransactionsAfter(Date date) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction.getDate().after(date)) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getTransactionsBefore(Date date) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction: list) {
      if (transaction.getDate().before(date)) {
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public void print(PrintWriter printer) {
    for (Transaction transaction: list) {
      printer.println(transaction.toString());
    }
  }

  public void printCsv(PrintWriter writer) {
    String[] headers = {"date","amount","to"};
    for(Transaction transaction : list){
      CsvPrinter csvPrinter = new CsvPrinter(writer, headers);
      csvPrinter.write(transaction);
      csvPrinter.close();
    }
  }
}
