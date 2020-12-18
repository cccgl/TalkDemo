package com.lei.Thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{

    DatagramSocket socket=null;
    BufferedReader reader=null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend(int fromPort,String toIP,int toPort) throws Exception {
        this.fromPort=fromPort;
        this.toIP=toIP;
        this.toPort=toPort;

        socket=new DatagramSocket(fromPort);
        reader=new BufferedReader(new InputStreamReader(System.in));


    }

    @Override
    public void run(){

        while(true)
        {
            try {
                String data=reader.readLine();
                byte[] datas=data.getBytes();
                DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,toPort));

                socket.send(packet);

                //bye只能关闭一条线路
                //老师和学生必须都说一次bye才能关闭两条线路
                if(data.equals("bye")) break;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        socket.close();
    }
}
