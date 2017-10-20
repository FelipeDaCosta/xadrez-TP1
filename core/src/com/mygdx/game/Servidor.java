package com.mygdx.game;

import java.rmi.registry.LocateRegistry;

public class Servidor {
    Servidor(){

        try{
            System.setProperty("java.tmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);
            //Servico c = new TableDealer();
            //Naming.rebind("Chess", (Remote) c);
        }catch(Exception c){
            c.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Servidor();
    }

}
