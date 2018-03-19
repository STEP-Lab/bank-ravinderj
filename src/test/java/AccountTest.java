import com.step.bank.Account.Account;
import com.step.bank.MinimumBalanceException.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException {
    account = new Account("1234", 1000);
  }

  @Test
  public void checkBalance() {
    assertThat(account.getBalance(), is(1000));
  }

  @Test
  public void getAccountNumber() {
    assertThat(account.getAccountNumber(), is("1234"));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException {
    Account account = new Account("1234", 500);
  }
}
