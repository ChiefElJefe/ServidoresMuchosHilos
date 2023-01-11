import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteMain {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost", 60000);
            PrintWriter fsalida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fentrada = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String cadena, cadenaRecibida;

            System.out.println("Introduce cadenas y recibelas en mayusculas. Escribe * para terminar la conexion");

            do {
                System.out.println("Introduce cadena: ");
                cadena = in.readLine();
                fsalida.println(cadena);
                cadenaRecibida = fentrada.readLine();
                System.out.println("Recibido: "+cadenaRecibida);
            }while (!cadena.contentEquals("*"));
            System.out.println("Fin de comunicación");

            fsalida.close();
            fentrada.close();
            in.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
