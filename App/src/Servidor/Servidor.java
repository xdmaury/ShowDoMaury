package Servidor;

import bd.BancoT;
import bd.Linhas;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maury
 */
public class Servidor extends Thread {

    StringBuffer stb = null;
    BancoT banco = null;

    Socket cliente = null;
    DataInputStream entrada = null;
    DataOutputStream saida = null;

    public Servidor(Socket cliente, StringBuffer stb) {
       banco =  new BancoT(false);
        
        this.stb = stb;
        this.cliente = cliente;
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            saida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {

        while (true) {

            try {
                acao();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }

        }

    }
    
    Linhas pergunta = banco.sl(banco.perguntas_pergunta);

    public synchronized void acao() throws IOException {
        String dadoLido = entrada.readUTF();
        
        ArrayList pr=pergunta.ar();
       
        
        
      
        int ind=new Random().nextInt(pr.size());
        String pertunta= (String) pr.get(ind);
        System.out.println(pertunta);
        pr.remove(ind);

        /*if(dadoLido.contains("Bom Dia")){
         stb.append(dadoLido+"\n"+respostas[0][new Random().nextInt(2)]);
         
         }*/
        saida.writeUTF(stb.toString());
        saida.flush();

    }

    public static void main(String args[]) throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(3312);

                    while (true) {
                        new Servidor(server.accept(), new StringBuffer()).start();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();

    }
}
