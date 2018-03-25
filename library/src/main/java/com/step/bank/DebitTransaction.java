package com.step.bank;

import java.util.Date;

public class DebitTransaction {
  private final Date date;
  private final float amount;
  private final String to;

  public DebitTransaction(float amount, String to) {
    this.date = new Date();
    this.amount = amount;
    this.to = to;
  }
  protected DebitTransaction(Date date, float amount, String to) {
    this.date = date;
    this.amount = amount;
    this.to = to;
  }

  public Date getDate() {
    return date;
  }
}
