package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    private ServerSocket serverSocket;
    private Socket socket;


    public Server(){

    }

    //lancement des serveur et connexion des client au serveur
    public void run(){

        try {
            serverSocket = new ServerSocket(8889);
            System.out.println("Serveur Demarré");
            while(!serverSocket.isClosed()) {
                System.out.println("attend des clients...");
                socket = serverSocket.accept();
                System.out.println("Connecté au serveur ");
                ClientHandler clientThread = new ClientHandler(socket, clients);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //fermeture du Serveur
    public void serverClosed() throws IOException{

        if(socket!=null && !(serverSocket.isClosed())) {
            //socket.close();
            this.serverSocket.close();
            System.out.println("Serveur deconnecté");
        }
    }
}