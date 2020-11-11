package com.company;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.Util.ArrayList;

public class Servidor<total> extends Thread {
    private static ArrayList<BufferedWriter> clientes;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;

    public Servidor(Socket con){
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

        ServerSocket servidor = new ServerSocket (9999);
        System.out.println ("porta 9999 aberta");

        System.out.println ("Aguardando ...");
        Socket cliente = servidor.accept();

        System.out.println("nova conexao "+ cliente.getIntAddress().getHostAddress());

        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        n1 = dados.readInt();
        n2 = dados.readInt();
.
        operacao = (char) dados.readInt();
        if (operacao == 5){
            p = '%';
            total = (Double.parseDouble(String.valueOf(n1))  * Double.parseDouble(String.valueOf(n2)) / 100);
        }
        if (operacao == 6){
            p = 'raiz';
            total = Math.sqrt(Double.parseDouble(String.valueOf(nm1)));
        }
        if (operacao == 7){
            p = '^';
            total = (int) Math.pow(n1,n2);
        }

        else{
            System.out.print("operacao invalida");
        }

        resultado.writeDouble(total);
        resultado.writeChar(p);
        resultado.flush();
        servidor.closse();








    }
}