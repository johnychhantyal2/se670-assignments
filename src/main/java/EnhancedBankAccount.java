import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EnhancedBankAccount {
    private double balance;
    private final AccountType accountType;
    private final List<Transaction> transactionHistory;

    public EnhancedBankAccount(double initialBalance, AccountType accountType) {
        validateInitialBalance(initialBalance);
        this.balance = initialBalance;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
        logTransaction("Account Opened", initialBalance);
    }

    public void deposit(double amount) {
        validateTransactionAmount(amount);
        balance += amount;
        logTransaction("Deposit", amount);
    }

    public void withdraw(double amount) {
        validateTransactionAmount(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        logTransaction("Withdrawal", -amount);
    }

    public void applyInterest() {
        if (balance <= 0) {
            return; // No interest applied to negative or zero balances
        }
        double interest = calculateInterest();
        applyInterestToBalance(interest);
        logInterestApplied(interest);
    }

    private void applyInterestToBalance(double interest) {
        balance += interest;
    }

    private void logInterestApplied(double interest) {
        logTransaction("Interest Applied", interest);
    }


    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    private double calculateInterest() {
        double interestRate = accountType.getInterestRate();
        return balance * interestRate / 100;
    }

    private void logTransaction(String type, double amount) {
        transactionHistory.add(new Transaction(type, LocalDateTime.now(), amount, balance));
    }

    private void validateInitialBalance(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
    }

    private void validateTransactionAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
    }

    public enum AccountType {
        SAVINGS(1.5),
        CHECKING(0.5),
        FIXED_DEPOSIT(3.0);

        private final double interestRate;

        AccountType(double interestRate) {
            this.interestRate = interestRate;
        }

        public double getInterestRate() {
            return interestRate;
        }
    }

    public static class Transaction {
        private final String type;
        private final LocalDateTime dateTime;
        private final double amount;
        private final double balanceAfterTransaction;

        public Transaction(String type, LocalDateTime dateTime, double amount, double balanceAfterTransaction) {
            this.type = type;
            this.dateTime = dateTime;
            this.amount = amount;
            this.balanceAfterTransaction = balanceAfterTransaction;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "type='" + type + '\'' +
                    ", dateTime=" + dateTime +
                    ", amount=" + amount +
                    ", balanceAfterTransaction=" + balanceAfterTransaction +
                    '}';
        }
    }

    public static void main(String[] args) {
        EnhancedBankAccount account = new EnhancedBankAccount(1000, AccountType.SAVINGS);
        account.deposit(500);
        account.withdraw(200);
        account.applyInterest();
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Transaction History:");
        account.getTransactionHistory().forEach(System.out::println);
    }
}
