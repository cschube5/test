import java.io.*;
import java.net.ServerSocket;
import java.io.*;
import java.net.*;

/**
 * Created by ChristopherSchubert on 2/25/17.
 */
public class server {

    public static void main(String[] args) {
        System.out.println("Welcome to the Chat");
        System.out.println("Starting the Chat Now!");

        try{

            ServerSocket ss = new ServerSocket(1201);
            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin=" ",msgout="";

            while(!msgin.equals("end")){
                msgin = din.readUTF();
                System.out.println(msgin);
                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            s.close();
        }catch (Exception e){
            //handle exceptions
        }
    }
}
