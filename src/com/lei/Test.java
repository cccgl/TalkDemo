package com.lei;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress address1=InetAddress.getByName("127.0.0.1");
        System.out.println(address1);
        InetAddress address2=InetAddress.getByName("www.bilibili.com");
        System.out.println(address2);
        InetAddress address3=InetAddress.getLocalHost();
        System.out.println(address3);

        System.out.println(InetAddress.getLocalHost());
    }

}
