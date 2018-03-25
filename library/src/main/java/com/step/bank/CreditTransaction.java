package com.step.bank;

import java.util.Date;

class CreditTransaction extends Transaction {

  CreditTransaction(float amount, String to) {
    super(new Date(), amount, to);
  }

  protected CreditTransaction(Date date, float amount, String to) {
    super(date, amount, to);
  }
}
