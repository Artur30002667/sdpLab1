import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(4242);
        Socket clientSocket = serverSocket.accept(); // bloqueante
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        /* BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); */
        while(clientSocket.isConnected()){
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String command = in.readLine();
            out.println("Server: received command " + command);
            if (command == "Q"){
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            }
        }
      // PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      //  BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    //    String command = in.readLine();
     //   out.println("Server: received command " + command);


     /*   in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();  */
    }
}
