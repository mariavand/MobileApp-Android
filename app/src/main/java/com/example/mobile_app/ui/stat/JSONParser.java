package com.example.mobile_app.ui.stat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser extends AsyncTask<Void,Void,Boolean> {

    // Variables declaration
    Context c;
    String jsonData;
    EditText datefrom;
    EditText dateto;
    TextView resemv;
    TextView resemva;
    TextView resemvb;
    TextView restotal;


    // Declaring a ProgressDialog. When used, user cannot click anything and they are asked to wait
    ProgressDialog pd;

    //An array list that will save the required data from JSON for our app
    ArrayList<StatVac> data = new ArrayList<>();

    //Constructor
    public JSONParser(Context c, String jsonData, EditText datefrom, EditText dateto, TextView resemv, TextView resemva, TextView resemvb, TextView restotal) {
        this.c = c;
        this.jsonData = jsonData;
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
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    // In background starts parsing, parse method is implemented later on
    @Override
    protected Boolean doInBackground(Void... voids) {
        return this.parse();
    }

    // After parsing, this method is executed
    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        //Dismissing the message
        pd.dismiss();

        //If it is parsed then we can calculate the vaccinations needed
        if(isParsed)
        {
            //BINDING & CALCULATIONS

            //Calculations are based on the previous project (Web_App - ajax in statistics)
            int res_emv = 0;
            int res_emva = 0;
            int res_emvb = 0;
            int res_total = 0;

            //We change dates format so that they match JSON format (Reference Date)
            String from = (datefrom.getText()).toString()+"T00:00:00";
            String to = (dateto.getText()).toString()+"T00:00:00";

            //Declarations of helping variables
            int temp = 0;
            String d = "";

            //Running through all the data
            for(int i = 0; i < data.size(); i++){

                // For each data we need to check if the ref. date is between from date
                //and to date which are given by user
                d = data.get(i).getRefDate();

                if(d.compareTo(from) >= 0 && d.compareTo(to) <= 0){

                    //Calculating vaccinations, vaccinations a-dose and vaccinations b-dose
                    temp = data.get(i).getDayTotal();
                    res_emv = res_emv + temp;

                    temp = data.get(i).getDailyDoseOne();
                    res_emva = res_emva + temp;

                    temp = data.get(i).getDailyDoseTwo();
                    res_emvb = res_emvb + temp;
                }
            }
            //After this loop d variable has the last date that exists in downloaded json
            for(int i = 0; i < data.size(); i++) {

                String r = data.get(i).getRefDate();
                // If reference date is the last available date, then we calculate total
                //vaccinations until last date of data
                if (d.equals(r)) {

                    temp = data.get(i).getTotalVac();
                    res_total = res_total + temp;
                }

            }

            //Setting Text View with the results of calculations
            //They are shown in fragment_stat.xml
            resemv.setText(String.valueOf(res_emv));
            resemva.setText(String.valueOf(res_emva));
            resemvb.setText(String.valueOf(res_emvb));
            restotal.setText(String.valueOf(res_total));


        }else
        {
            //If parsing failed, then we show a message
            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }
    }

    //Parsing method which is executed in doInBackground (returns a boolean)
    private Boolean parse()
    {
        try
        {
            //Declaration of Json array (which consists of json objects) and json object
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;

            //Clearing the data
            data.clear();

            for (int i = 0; i < ja.length(); i++)
            {
                //Assigning json object with an object of array
                jo=ja.getJSONObject(i);

                //Getting the required parameters which will be used in calculations
                String rd=jo.get("referencedate").toString();
                int dt=Integer.parseInt(jo.get("daytotal").toString());
                int ddOne=Integer.parseInt(jo.get("dailydose1").toString());
                int ddTwo=Integer.parseInt(jo.get("dailydose2").toString());
                int total=Integer.parseInt(jo.get("totalvaccinations").toString());

                //Creating an object of StatVac to add it in arraylist
                StatVac temp = new StatVac(rd, dt, ddOne, ddTwo, total);

                //Adding StatVac object to data list
                data.add(temp);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
