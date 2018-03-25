package com.step.bank;

import java.util.Date;

public class Transaction {
  private final Date date;
  private final float amount;
  private final String to;

  public Transaction(Date date, float amount, String to) {
    this.date = date;
    this.amount = amount;
    this.to = to;
  }

  public Date getDate() {
    return date;
  }
}
