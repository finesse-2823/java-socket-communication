package socket_programming.utils;
//import CN.client.*;

public class CalculatorUtils {
    public static double evaluateExpression(String expression) throws Exception {
        // Implement your scientific calculator logic here
        // For simplicity, let's just parse the input as a double
        return Double.parseDouble(expression);
    }
}
