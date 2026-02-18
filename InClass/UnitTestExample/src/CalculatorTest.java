import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.*;
public class CalculatorTest {
    private UnitTests.Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new UnitTests.Calculator();
    }

    @Test
    @DisplayName("Adding two numbers")
    void addTwoNumbers() {
        int result = calculator.add(1, 2);
        assertEquals(3, result, "1+2 should be equal to 3");
    }

    @Test
    @DisplayName("Subtracting two numbers")
    void subtractTwoNumbers() {
        int result = calculator.subtract(1, 2);
        assertEquals(2, result, "1+2 should be equal to 2");
    }


}
