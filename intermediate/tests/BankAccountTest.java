import java.util.UUID;
import org.junit.Assert;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;

public class BankAccountTest {
    @Test
    public void bankAccountCreation() {
        BankAccount bankAccount = new BankAccount();
        Integer expectedBalance = 0;
        MatcherAssert.assertThat(bankAccount.accountNumber, instanceOf(UUID.class));
        Assert.assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    public void bankAccountDepositAndWithdraw() throws Exception {
        BankAccount bankAccount = new BankAccount();
        Integer expectedBalance = 17;
        bankAccount.deposit(18);
        bankAccount.withdraw(1);
        Assert.assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test(expected = Exception.class)
    public void bankAccountDepositError() throws Exception {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(-18);
    }

    @Test(expected = Exception.class)
    public void bankAccountWithdrawError() throws Exception {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(18);
    }
}
