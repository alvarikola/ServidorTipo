package servidortipo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTipo {

   
    public static void main(String[] args) {
        // Puerto del servidor
        int port = 1234;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");
            
            while (true) {
                // Aceptar una conexion
                Socket client = server.accept();
                System.out.println("Cliente conectado: " + client.getInetAddress());
                
                // Leer y responder al cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter output = new PrintWriter(client.getOutputStream(), true);
                
                int numeroSaludo = 0;
                while (++numeroSaludo <= 5) {
                    String message = input.readLine();
                    System.out.println("Se ha recibido este mensaje: " + message);
                    
                    String answer = "Saludos " + numeroSaludo + " desde el servidor";
                    output.println(answer);
                }
                
                
                
                
                client.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
