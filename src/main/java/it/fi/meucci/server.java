package it.fi.meucci;
import java.io.*;
import java.net.*;
import java.util.*;


public class server {

    ServerSocket server=null;
    Socket client=null;
    String stringaRicevuta=null;
    String stringamodificata=null;
    BufferedReader indalClient;
    DataOutputStream outversoClient;

    public Socket attendi(){

        try{
            System.out.println("1, server partito");
            server = new ServerSocket(6789);
            client=server.accept();
            server.close();
            indalClient= new BufferedReader(new InputStreamReader(client.getInputStream()));
            outversoClient= new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e){}
        return client;
    }

    public void comunica(){
        try{
        System.out.println("3, benvenuto, scrivi dai");
        stringaRicevuta = indalClient.readLine();
        System.out.println("6, ricevuta "+stringaRicevuta);
        stringamodificata=stringaRicevuta.toUpperCase();
        System.out.println("7, invio la stringa modificata");
        outversoClient.writeBytes(stringamodificata+'\n');
        System.out.println("9 daje un po");

    }catch(Exception e){}
}
    
}
