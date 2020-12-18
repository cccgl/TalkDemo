package com.lei.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReader01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket=new DatagramSocket(6666);

        while(true)
        {
            byte[] container=new byte[1024];
            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            socket.receive(packet);

            byte[] data=packet.getData();
            String rd=new String(data,0, data.length);

            System.out.println(rd);

            if(rd.startsWith("bye"))
                break;



        }
        socket.close();
    }
}
