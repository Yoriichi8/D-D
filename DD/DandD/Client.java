package DandD;
//---------------------------------
import java.io.*;
import java.net.*;

public class Client {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    int dato = 0;

    public Client() {
        Dado dice = new Dado(GAME_WIDTH, GAME_HEIGHT);
        Socket socket;
        String hostName = "localhost";
        int portNumber = 8000;
        try {
            socket = new Socket(hostName, portNumber);
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            if (message.equals("START")) {
                System.out.println("La partita è iniziata!");
                //partita
                new Selezione();
            }
            if(dice.dado_somma != 0){
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeInt(dice.dado_somma); // invia il dato di valore 50 al server

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                
                dato = dataInputStream.readInt(); // riceve il dato dal server
                System.out.println("Il client ha ricevuto il dato " + dato);
            }
            

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
