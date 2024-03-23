package bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started. Waiting for clients...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner serverScanner = new Scanner(System.in);

            String clientMessage, serverMessage;

            while (true) {
                // Đọc dữ liệu từ client
                if ((clientMessage = clientInput.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                }

                // Nhập dữ liệu từ server và gửi tới client
                System.out.print("Server: ");
                serverMessage = serverScanner.nextLine();
                serverOutput.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}