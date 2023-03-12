package DandD;
//------------------------------------------
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int portNumber = 8000;
        ServerSocket serverSocket = null;
        int dato;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Il Server è attivo e ascolta sulla porta " + portNumber);
            while (true) {
                Socket player1Socket = serverSocket.accept();
                System.out.println("Player 1 si è connesso.");
                //----------------------------------------------------------------
                Socket player2Socket = serverSocket.accept();
                System.out.println("Player 2 si è connesso.");
                //----------------------------------------------------------------
                // Invia un messaggio ai client per iniziare la partita
                player1Socket.getOutputStream().write("START".getBytes());
                player2Socket.getOutputStream().write("START".getBytes());
                /* Se si connettono gli altri player*/
                Socket player3Socket = serverSocket.accept();
                System.out.println("Player 3 si è connesso.");
                if(player3Socket == serverSocket.accept()){
                    player3Socket.getOutputStream().write("START".getBytes());
                }

                Socket player4Socket = serverSocket.accept();
                System.out.println("Player 4 si è connesso.");
                if(player4Socket == serverSocket.accept()){
                    player4Socket.getOutputStream().write("START".getBytes());
                }
                //----------------------------------------------------------------
                InputStream inputStream = player1Socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                dato = dataInputStream.readInt(); // riceve il dato dal client
                System.out.println("Il server ha ricevuto il dato " + dato);
                
                OutputStream outputStream1 = player1Socket.getOutputStream();
                DataOutputStream dataOutputStream1 = new DataOutputStream(outputStream1);
                dataOutputStream1.writeInt(dato);

                dataInputStream.close();
                inputStream.close();
                //----------------------------------------------------------------
                InputStream inputStream2 = player2Socket.getInputStream();
                DataInputStream dataInputStream2 = new DataInputStream(inputStream2);
                dato = dataInputStream2.readInt(); // riceve il dato dal client
                System.out.println("Il server ha ricevuto il dato " + dato);
                
                OutputStream outputStream2 = player2Socket.getOutputStream();
                DataOutputStream dataOutputStream2 = new DataOutputStream(outputStream2);
                dataOutputStream2.writeInt(dato);

                dataInputStream2.close();
                inputStream2.close();
                //------------------------------------------------------------------
                InputStream inputStream3 = player3Socket.getInputStream();
                DataInputStream dataInputStream3 = new DataInputStream(inputStream3);
                dato = dataInputStream3.readInt(); // riceve il dato dal client
                System.out.println("Il server ha ricevuto il dato " + dato);
                
                OutputStream outputStream3 = player3Socket.getOutputStream();
                DataOutputStream dataOutputStream3 = new DataOutputStream(outputStream3);
                dataOutputStream3.writeInt(dato);

                dataInputStream3.close();
                inputStream3.close();
                //------------------------------------------------------------------
                InputStream inputStream4 = player4Socket.getInputStream();
                DataInputStream dataInputStream4 = new DataInputStream(inputStream4);
                dato = dataInputStream4.readInt(); // riceve il dato dal client
                System.out.println("Il server ha ricevuto il dato " + dato);

                OutputStream outputStream4 = player4Socket.getOutputStream();
                DataOutputStream dataOutputStream4 = new DataOutputStream(outputStream4);
                dataOutputStream4.writeInt(dato);

                dataInputStream4.close();
                inputStream4.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
