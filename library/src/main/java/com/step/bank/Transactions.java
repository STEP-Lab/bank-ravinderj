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
}
