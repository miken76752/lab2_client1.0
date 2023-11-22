import java.io.IOException;
import java.net.Socket;

public class Program {
    public Program() {
    }

    public static void main(String[] args) {
        String serverAddress = "127.5.5.1";
        int serverPort = 12345;

        try {
            Socket serverConnect = new Socket(serverAddress, serverPort);
            Thread inputThread = new Thread(new ConnectInputMessage(serverConnect));
            Thread receiveThread = new Thread(new ReceiveMessageFromServer(serverConnect));
            inputThread.start();
            receiveThread.start();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}