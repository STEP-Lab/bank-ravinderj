package com.step.bank;

import java.util.ArrayList;

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
}
