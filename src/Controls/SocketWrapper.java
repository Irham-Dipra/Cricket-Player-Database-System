package Controls;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketWrapper {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public String name;

    public SocketWrapper(String s, int port, String name) throws IOException { // used by the client
        System.out.println("Connecting to server...");
        this.socket = new Socket(s, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        this.name = name;
    }

    public SocketWrapper(Socket s) throws IOException { // used by the server
        this.socket = s;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void write(Object o) throws IOException {
        oos.writeObject(o);
    }

    public void flush() throws IOException
    {
        oos.flush();
    }

    public void closeConnection() throws IOException {
        ois.close();
        oos.close();
    }

    public void closeSocket() throws IOException {
        socket.close();
    }
}
