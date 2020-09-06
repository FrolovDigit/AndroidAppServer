package com.example.razuvaevlev.lionfishserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server implements Runnable{


    public void run(){

        try{
            ServerSocket serverSock = new ServerSocket(8080);


            while(MainActivity.serverState){
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/html; charset=utf-8");
                writer.println();
                writer.println("");
                writer.println(MainActivity.hkl);
                writer.close();

            }


        }catch (IOException ex){

            ex.printStackTrace();

        }

    }
}