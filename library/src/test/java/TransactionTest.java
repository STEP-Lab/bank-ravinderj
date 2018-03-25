import com.step.bank.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void name() {
    Date date = new Date();
    Transaction transaction = new Transaction(date, 1000, "another_account");
    assertThat(transaction.getDate(), is(date));
  }
}
