package com.example.orbit_tracker_v1.space_track;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class DownloadTLE {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String baseURL = "https://www.space-track.org";
            String authPath = "/ajaxauth/login";
            String userName = "jtegge@zivaro.com";
            String password = "dEd7a!UApsxSuz3jXjfV";
            String query = "/basicspacedata/query/class/gp/LAUNCH_DATE/%3CCURRENT-14/orderby/LAUNCH_DATE%20desc/limit/30/";


            CookieManager manager = new CookieManager();
            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(manager);

            URL url = new URL(baseURL+authPath);

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            String input = "identity="+userName+"&password="+password;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            url = new URL(baseURL + query);

            br = new BufferedReader(new InputStreamReader((url.openStream())));

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            url = new URL(baseURL + "/ajaxauth/logout");
            br = new BufferedReader(new InputStreamReader((url.openStream())));
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}