package bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            while (true) {
                // Send "time" message to the server
                out.println("time");

                // Receive the time from the server
                String time = in.readLine();
                System.out.println("Received from server: " + time);

                Thread.sleep(1000); // Wait for 1 second
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
