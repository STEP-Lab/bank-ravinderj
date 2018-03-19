import com.step.bank.Account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() {
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
}
