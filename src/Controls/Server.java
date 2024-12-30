package Controls;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
    static Scanner scanner = new Scanner(System.in);
    private ServerSocket serverSocket;
    public static ArrayList<Player> playerList = new ArrayList<>();
    public static HashMap<String, String> userMap = new HashMap<>();
    public static HashMap<String, String> imageMap = new HashMap<>();
    public static HashMap<String, String> initialMap = new HashMap<>();

    Server() { 
        try {
            fileOperations.loadFile(playerList);
            fileOperations.loadCredentials(userMap);
            fileOperations.loadImages(imageMap);
            fileOperations.loadInitial(initialMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
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
