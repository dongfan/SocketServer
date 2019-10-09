import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("server started : 5001");

        while (true) {
            Socket socket = serverSocket.accept();

            ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
            String inStr = instream.readUTF();

            System.out.println("inStr from client : " + inStr);

            ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
            outstream.writeUTF(inStr + "from server");
            outstream.flush();

        }

    }
}
