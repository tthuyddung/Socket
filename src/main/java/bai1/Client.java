package bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);

            Scanner clientScanner = new Scanner(System.in);

            String serverMessage, clientMessage;

            while (true) {
                // Nhập dữ liệu từ client và gửi tới server
                System.out.print("Client: ");
                clientMessage = clientScanner.nextLine();
                clientOutput.println(clientMessage);

                // Đọc dữ liệu từ server
                if ((serverMessage = serverInput.readLine()) != null) {
                    System.out.println("Server: " + serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}