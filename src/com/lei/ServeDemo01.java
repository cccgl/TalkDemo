package com.lei;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeDemo01 {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        int port=9999;
        try {
            //该类实现了将数据写入字节数组的输出流
            baos=new ByteArrayOutputStream();
            //类实现了服务器套接字。 服务器套接字等待通过网络进入的请求。 它根据该请求执行一些操作，然后可能将结果返回给请求者
            serverSocket=new ServerSocket(9999);
            //侦听要连接到此套接字并接受它。   侦听到了我们在服务端定义的socket
            socket=serverSocket.accept();
            //输出流
            is=socket.getInputStream();
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            //关闭资源 从下到上
            baos.close();
            is.close();
            socket.close();
            serverSocket.close();
        }
    }
}
