package com.step.bank;

import java.util.Date;

public class CreditTransaction {
  private final Date date;
  private final float amount;
  private final String to;

  public CreditTransaction(float amount, String to) {
    this.date = new Date();
    this.amount = amount;
    this.to = to;
  }

  protected CreditTransaction(Date date, float amount, String to) {
    this.date = date;
    this.amount = amount;
    this.to = to;
  }

  public Date getDate() {
    return date;
  }
}
