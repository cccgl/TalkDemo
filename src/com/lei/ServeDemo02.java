package com.lei;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServeDemo02
{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9000);
        //监听客户端连接 会一直监听客户端是否连接
        Socket socket=serverSocket.accept();

        InputStream is=socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(new File("recerve.png"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1)
        {
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}