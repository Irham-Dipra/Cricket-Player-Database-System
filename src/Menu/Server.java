package Menu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;

    Server() {
        userMap = new HashMap<>();
        userMap.put("Kolkata Knight Riders", "kkr");
        userMap.put("Rajasthan Royals", "rr");
        userMap.put("Delhi Capitals", "dc");
        userMap.put("Sunrisers Hydrabad", "srh");
        userMap.put("Gujarat Lions", "gl");
        userMap.put("Kings XI Punjab", "kxip");
        userMap.put("Mumbai Indians", "mi");
        userMap.put("Royal Challengers Bangalore", "rcb");
        userMap.put("Chennai Super Kings", "csk");
        userMap.put("Lucknow Super Giants", "lsg");
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        new ReadThreadServer(userMap, socketWrapper);
    }

    public static void main(String[] args) {
        new Server();
    }
}
