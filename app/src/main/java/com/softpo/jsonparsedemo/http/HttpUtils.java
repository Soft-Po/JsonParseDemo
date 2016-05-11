package com.softpo.jsonparsedemo.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by softpo on 2016/5/10.
 */
public class HttpUtils {
    public static String getData(String path){
        String ret = null;
        InputStream in = null;
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.connect();
            if(conn.getResponseCode() == 200){
               in = conn.getInputStream();

                baos = new ByteArrayOutputStream();

                byte[] buf = new byte[1024];

                while (true){
                    int len = in.read(buf);

                    if(len==-1){
                        break;
                    }

                    baos.write(buf,0,len);
                }

                byte[] data = baos.toByteArray();

                ret = new String(data);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  ret;
    }
}
