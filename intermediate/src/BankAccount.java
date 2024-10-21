import java.util.UUID;

public class BankAccount {
    public UUID accountNumber;
    private Integer balance;

    public BankAccount() {
        accountNumber = UUID.randomUUID();
        balance = 0;
    }

    public void deposit(Integer amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit should be greater than 0");
        }
        this.balance += amount;
    }

    public void withdraw(Integer amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit should be greater than 0");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance for withdraw");
        }
        this.balance -= amount;
    }

    public Integer getBalance() {
        return this.balance;
    }
}
