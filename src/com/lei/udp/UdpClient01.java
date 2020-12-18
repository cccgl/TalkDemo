package com.lei.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket=new DatagramSocket();

        String message="Hello World";
        InetAddress localhost=InetAddress.getByName("localhost");
        int port =9090;

        DatagramPacket packet=new DatagramPacket(message.getBytes(),0,message.length(),localhost,port);

        socket.send(packet);

        socket.close();
    }
}
