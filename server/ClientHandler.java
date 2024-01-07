package socket_programming.server;

//import socket_programming.utils.CalculatorUtils;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String input;
            while ((input = reader.readLine()) != null) {
                try {
                    double result = evaluateExpression(input);
                    writer.println("Result: " + result);
                } catch (Exception e) {
                    writer.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double evaluateExpression(String expression) throws Exception {
        // Implement your scientific calculator logic here
        // For simplicity, let's just parse the input as a double
        return Double.parseDouble(expression);
    }
}
