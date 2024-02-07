import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EnhancedBankAccountTest {

    private EnhancedBankAccount savingsAccount;

    @BeforeEach
    public void setUp() {
        // Initialize a savings account with an initial balance of 1000 for each test
        savingsAccount = new EnhancedBankAccount(1000, EnhancedBankAccount.AccountType.SAVINGS);
    }

    @Test
    public void testDeposit() {
        savingsAccount.deposit(500);
        Assertions.assertEquals(1500, savingsAccount.getBalance(), "Balance should be 1500 after depositing 500.");
    }

    @Test
    public void testWithdraw() {
        savingsAccount.withdraw(200);
        Assertions.assertEquals(800, savingsAccount.getBalance(), "Balance should be 800 after withdrawing 200.");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(1200),
                "Should throw IllegalArgumentException for withdrawal amount greater than balance.");
    }

    @Test
    public void testApplyInterest() {
        savingsAccount.applyInterest();
        // Assuming the interest rate for SAVINGS account is 1.5%
        double expectedInterest = 1000 * 1.5 / 100;
        Assertions.assertEquals(1000 + expectedInterest, savingsAccount.getBalance(),
                "Balance should include interest applied.");
    }

    @Test
    public void testTransactionHistoryAfterDeposit() {
        savingsAccount.deposit(500);
        Assertions.assertFalse(savingsAccount.getTransactionHistory().isEmpty(), "Transaction history should not be empty after deposit.");
    }

    @Test
    public void testTransactionHistoryAfterWithdraw() {
        savingsAccount.withdraw(200);
        Assertions.assertFalse(savingsAccount.getTransactionHistory().isEmpty(), "Transaction history should not be empty after withdrawal.");
    }

    @Test
    public void testNegativeDeposit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.deposit(-100),
                "Should throw IllegalArgumentException for negative deposit amount.");
    }

    @Test
    public void testNegativeWithdrawal() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> savingsAccount.withdraw(-100),
                "Should throw IllegalArgumentException for negative withdrawal amount.");
    }

    @Test
    public void testNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new EnhancedBankAccount(-100, EnhancedBankAccount.AccountType.SAVINGS),
                "Should throw IllegalArgumentException for negative initial balance.");
    }
}
