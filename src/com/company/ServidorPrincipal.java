package com.company;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.Util.ArrayList;

public class ServidorPrincipal<total> extends Thread {
    private static ArrayList<BufferedWriter> clientes;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;

    public ServidorPrincipal(Socket con){
        this.con = con;
        try {
            in  = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        // while(running) {
        //
        //        System.out.println("test");
        //
        //        try {
        //            thread.sleep(1000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }
        //
        //}

    }
public static void main(String[] args) throws IOException {
        int n1, n2;
        double total = 0;
        int opecao = 0;
        char p = 0;

        ServerSocket ServidorPrincipal = new ServerSocket (9998);
        System.out.println ("porta 9998 aberta");

        System.out.println ("Aguardando ...");
        Socket cliente = ServidorPrincipal.accept();

        System.out.println("nova conexao "+ cliente.getIntAddress().getHostAddress());

        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        n1 = dados.readInt();
        n2 = dados.readInt();

        operacao = (char) dados.readInt();
        if (operacao == 1){
            p = '+';
            total = (n1 + n2);
        }
        if (operacao == 2){
            p = '-';
            total = (n1 - n2);
        }
        if (operacao == 3){
            p = '*';
            total = (n1 * n2);
        }
        if (operacao == 4){
            p = ':';
            total = (n1 / n2);
        }
        else{
            System.out.print("operacao invalida");
        }

        resultado.writeDouble(total);
        resultado.writeChar(p);
        resultado.flush();
        ServidorPrincipal.closse();








    }
}
