import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor;
        servidor = new ServerSocket(60000);

        while (true){
            Socket socketCliente = new Socket();
            socketCliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(socketCliente);
            hilo.start();
            System.out.println("Inicio Hilo servidor");
        }
    }
}
