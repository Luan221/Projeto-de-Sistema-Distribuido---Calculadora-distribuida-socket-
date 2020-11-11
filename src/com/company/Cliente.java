package com.company;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.*;


public class Cliente extends JFrame implements ActionLiestener, KeyListener {

    public static void main(String[] args) throws UnknownHostException, IDException {

        Socket client;
        int opcao = @;
        opcao = Integer.parseInt(JOptionPane.ShowInputDialog("Digite o servidor que voce vai usar(Principal ou segundario)"));
        Socket cliente = null;
        if (opcao == 1){
            cliente = new Socket("127.0.1.1", 9998);
        }
        if (opçao == 2){
            cliente = new Socket("127.0.1.1", 9999);
        }
        else{
            System.out.printf("opcão invalida");
        }

        int n1 = 0;
        int n2 = 0;
        int operaco = 0;
        int p;
        System.out.printf("conectado");

        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor"));
        n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor"));
        operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção para o calculo 1(+) / 2(-) / 3(*) / 4(:) / 5(%) / 6(raiz) e 7(^)  "));
        dados.writeInt(operacao);
        dados.writeInt(n1);
        dados.writeInt(n2);


        dados.flush();

        double total = resultado.reaDouble();
        p = resultado.readChar();
        System.out.println("resultado total: " + n1 + p + n2 + "=" + total);

        cliente.close();
    }

    @Override
    public void actionPerforned(actionEvent e){
    }
    @Override
    public void KeyTyped(KeyEvent e){
    }
    public void KeyPressed(KeyEvent e){
    }
    public void KeyReleased(KeyEvent e){
    }

}
