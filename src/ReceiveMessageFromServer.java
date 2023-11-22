import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveMessageFromServer implements Runnable {
    private InputStream inputStreamServer;

    public ReceiveMessageFromServer(Socket serverConnect) {
        try {
            this.inputStreamServer = serverConnect.getInputStream();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void run() {
        try {
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(this.inputStreamServer));

            String message;
            while((message = serverInput.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }
}