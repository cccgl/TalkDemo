package com.lei.URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDownload {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://i1.hdslb.com/bfs/face/bd6cac6be2d161a055ad7d913ac28792d8368e7a.jpg_64x64.jpg");

        HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();

        InputStream inputStream=urlConnection.getInputStream();

        FileOutputStream fos=new FileOutputStream("urlDownload.png");

        byte[] buffer=new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1)
        {
            fos.write(buffer,0,len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}
