package com.step.bank;

import java.util.Date;

class DebitTransaction extends Transaction {

  DebitTransaction(float amount, String to) {
    super(new Date(), amount, to);
  }
  protected DebitTransaction(Date date, float amount, String to) {
    super(date, amount, to);
  }
}
