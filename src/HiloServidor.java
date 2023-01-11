import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread{

    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;

    public HiloServidor(Socket s) throws IOException {
        System.out.println("Cree hilo servidor");
        socket = s;
        fsalida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        super.run();
        try {
            String cadena = "";
            boolean parar = false;

            while(!cadena.trim().equals("*") && !parar){
                System.out.println("En hilo: comunique con: " +socket.toString());
                try {
                    cadena = fentrada.readLine();
                    System.out.println("En hilo: leer cadena " +cadena);
                    fsalida.println(cadena.trim().toUpperCase());
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("Fin con "+socket.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
