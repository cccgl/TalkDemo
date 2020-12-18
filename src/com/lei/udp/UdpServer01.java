package com.lei.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket=new DatagramSocket(9090);

        byte[] buffer=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData()));

        socket.close();
    }

}
