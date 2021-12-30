package com.example.mobile_app.ui.stat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JSONDownloader extends AsyncTask<Void,Void,String> {

    // Variables declaration
    Context c;
    EditText datefrom;
    EditText dateto;
    TextView resemv;
    TextView resemva;
    TextView resemvb;
    TextView restotal;

    // Declaring a ProgressDialog. When used, user cannot click anything and they are asked to wait
    ProgressDialog pd;

    //Constructor
    public JSONDownloader(Context c, EditText datefrom, EditText dateto, TextView resemv, TextView resemva, TextView resemvb, TextView restotal) {
        this.c = c;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.resemv = resemv;
        this.resemva = resemva;
        this.resemvb = resemvb;
        this.restotal = restotal;
    }

    //Shows a message
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Download Data");
        pd.setMessage("Downloading...Please wait");
        pd.show();
    }

    // In background starts downloading, download method is implemented later on
    @Override
    protected String doInBackground(Void... voids) {
        return this.download();
    }

    // After downloading this method is executed
    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        //Dismissing the message
        pd.dismiss();
        //If there is an error, then we show a toast message that there is an error
        if(jsonData.startsWith("Error"))
        {
            Toast.makeText(c, jsonData, Toast.LENGTH_SHORT).show();
        }else
        {
            //If everything went well, then we call JSONParser class and execute
            //PARSE
            new JSONParser(c,jsonData,datefrom, dateto, resemv, resemva, resemvb, restotal).execute();

        }
    }

    //Download method which is executed in doInBackground
    private String download() {
        // Make a new connection
        Object connection = Connection.connect();
        // If connection has any Error, show the Error
        if (connection.toString().startsWith("Error")) {
            return connection.toString();
        }
        try {
            // We need an http connection
            HttpURLConnection con = (HttpURLConnection) connection;

            // If it responses Ok 200, we download Json
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //GET INPUT FROM STREAM
                InputStream is = new BufferedInputStream(con.getInputStream());
                //A buffer reader which reads the input stream
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                // Declaration of variables
                String line;
                StringBuffer jsonData = new StringBuffer();

                //READ
                while ((line = br.readLine()) != null) {
                    jsonData.append(line + "\n");
                }

                //CLOSE RESOURCES
                br.close();
                is.close();

                //RETURN JSON stringified
                return jsonData.toString();

            } else {
                // If Http response isn't Ok 200, then we show a message about the Response
                return "Error " + con.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
    }
}
