package com.lei.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo01 {
    public static void main(String[] args) throws IOException {
       // InetAddress serverIP=InetAddress.getByName("127.0.0.1");
        InetAddress serverIP=null;
        int port;
        Socket socket=null;
        OutputStream os=null;
        try {
            //本机ip
            serverIP=InetAddress.getByName("127.0.0.1");
            //设置交互端口号
            port=9999;
            //设置套接字
            socket=new Socket(serverIP,port);
            //输出流
            os=socket.getOutputStream();
            //写下hello world
            os.write("hello world".getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            //关闭资源 从下到上
            os.close();
            socket.close();


        }
    }
}
