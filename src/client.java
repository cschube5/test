import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;

/**
 * Created by ChristopherSchubert on 2/25/17.
 */
public class client {
    public static void main(String[] args) {
        System.out.println("Welcome to the Chat");
        System.out.println("Starting the Chat Now!");
        System.out.println("Mandira test2");

        try{
            Socket s = new Socket("10.189.70.31",1201);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin="",msgout="";
            while (!msgin.equals("end")){
                msgout = br.readLine();
                dout.writeUTF(msgout);
                msgin = din.readUTF();
                System.out.println(msgin);
            }
        }catch (Exception e){

        }
    }
}
