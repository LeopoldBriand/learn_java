package app.src.main.java.intermediate;

public class BankAccount {
    public String accountNumber;
    private Integer balance;

    public void deposit(Integer amount) {
        this.balance += amount;
    }

    public void withdraw(Integer amount) {
        this.balance -= amount;
    }

    public Integer getBalance() {
        return this.balance;
    }
}
