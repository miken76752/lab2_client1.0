import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {
    private Socket serverConnect;
    private BufferedReader userInput;
    private PrintWriter out;

    public ConnectInputMessage(Socket serverConnect) {
        this.serverConnect = serverConnect;

        try {
            this.userInput = new BufferedReader(new InputStreamReader(System.in));
            this.out = new PrintWriter(serverConnect.getOutputStream(), true);
            new BufferedReader(new InputStreamReader(serverConnect.getInputStream()));
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void run() {
        try {
            int clientNumber = Integer.parseInt(this.userInput.readLine());
            System.out.println("Ви підключилися як клієнт #" + clientNumber);

            while(true) {
                String message = this.userInput.readLine();
                this.out.println(message);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }
}