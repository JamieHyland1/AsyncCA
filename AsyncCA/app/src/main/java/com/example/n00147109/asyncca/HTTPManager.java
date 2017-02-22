package com.example.n00147109.asyncca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by N00147109 on 22/02/2017.
 */
public class HTTPManager {
    public static String getData(String uri) throws MalformedURLException {
        BufferedReader reader = null;

            try
            {
                URL url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                StringBuilder sb = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line = "";

                while((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }

                return sb.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }

            finally {
                if(reader != null){
                    try{
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        return null;
    }
}
