import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        double result = calculator.add(10, 20);
        Assertions.assertEquals(30, result);
    }

    @Test
    void subtract() {
        double result = calculator.subtract(20, 10);
        Assertions.assertEquals(10, result);
    }

    @Test
    void multiply() {
        double result = calculator.multiply(10, 20);
        Assertions.assertEquals(200, result);
    }

    @Test
    void divide() {
        double result = calculator.divide(20, 10);
        Assertions.assertEquals(2, result);
    }
}