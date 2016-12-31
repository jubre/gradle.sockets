package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by junior on 31/12/16.
 */
public class Server {

    final int PUERTO = 5000;

    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream salida;
    String mensajeRecibido;

    public void initServer(){
        BufferedReader entrada;

        try{
            serverSocket = new ServerSocket(PUERTO);
            socket = new Socket();

            System.out.println("Esperando Conexion");

            socket = serverSocket.accept();

            System.out.println("Una Conexion");

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new DataOutputStream(socket.getOutputStream());

            System.out.println("Confirmando Una Conexion");

            salida.writeUTF("Conexion exitosa");

            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);

            salida.writeUTF("Conexion exitosa recibida");
            salida.writeUTF("Gracias por conectarte, adios!");

            socket.close();

        }catch(Exception e){

        }
    }

}
