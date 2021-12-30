package com.example.mobile_app.ui.stat;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
    //Method for Connection
    public static Object connect (){

        try{
            //Declarations
            URL url = new URL("https://data.gov.gr/api/v1/query/mdg_emvolio");

            //Open Http connection between the app and the data.gov.gr server
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //Adding the required Token
            con.addRequestProperty("Authorization", "Token 75f06db619c2f639beab77e720c19554f2933dfd");
            //We will use Get method to get JSON data
            con.setRequestMethod("GET");
            //Setting Timeouts
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);
            con.setDoInput(true);

            //Returning the connection
            return con;

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        catch (IOException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
    }

}
