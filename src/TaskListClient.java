import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 4242);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      //  out.println("Q");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
        //    String[] commands = input.split();
            //pode-se bloquear logo aqui os 120 caracteres

   //         switch(commands[0]) {
                switch(input) {
                case "L":
                    out.println("L");
                    String response = in.readLine();
                    System.out.println(response);
                    break;

                case "R":
                    break;

                case "Q":
                    out.println("Q");
                    String response1 = in.readLine();
                    System.out.println(response1);
                    in.close();
                    out.close();
                    clientSocket.close();
                    break;

            }
        }

/*
        String response = in.readLine();
        System.out.println(response);
        in.close();
        out.close();
        clientSocket.close();*/
    }
}
