package socket_programming.client;

//import CN.utils.CalculatorUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
//import java.lang.*;

public class ScientificCalculatorClient {
    //static String sharedVariable input;
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. Enter mathematical expressions or 'exit' to quit.");

            while (true) {
                System.out.print("Expression: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(input);
                String result = reader.readLine();
                System.out.println("Server response: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
