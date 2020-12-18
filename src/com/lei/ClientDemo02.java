package com.lei;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientDemo02 {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket(InetAddress.getLocalHost(),9000);
        OutputStream os=socket.getOutputStream();
        FileInputStream fis=new FileInputStream((new File("Pictrue//11.png")));
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1)
        {
            os.write(buffer,0,len);
        }
        fis.close();
        os.close();
        socket.close();
    }
}
