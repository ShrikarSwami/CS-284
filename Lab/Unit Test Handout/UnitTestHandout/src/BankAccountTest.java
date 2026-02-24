import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount acct;

    @BeforeEach
    void setUp() {
        acct = new BankAccount(100.0);
    }


    //This test increases the bank balance and tests to see if it actually increases
    @Test
    void deposit_validAmount_increasesBalance() {
        acct.deposit(50.0);
        assertEquals(150.0, acct.getBalance(), 0.0001);
    }

    //This one withdraws and then checks to make sure that it properly withdraws the valid amount
    @Test
    void withdraw_validAmount_decreasesBalance() {
        acct.withdraw(20.0);
        assertEquals(80.0, acct.getBalance(), 0.0001);
    }

    // This withdraws more money than the account should have so this one throws the error
    @Test
    void withdraw_insufficientFunds_throwsException() {
        assertThrows(IllegalStateException.class, () -> acct.withdraw(1000.0));
    }
}