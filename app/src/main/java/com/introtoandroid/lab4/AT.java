package com.introtoandroid.lab4;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AT extends AsyncTask<String, Void, String> {
    TextView mytext;

    public AT(TextView mytext) {
        this.mytext = mytext;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;


        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int i = 0;
        while (i < 20) {
            try {
                line += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

    return line;
}

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        String text = o.substring(10,23);
        mytext.setText(text);
    }
}
