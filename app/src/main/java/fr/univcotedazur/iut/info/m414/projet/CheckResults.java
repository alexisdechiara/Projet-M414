package fr.univcotedazur.iut.info.m414.projet;

import android.os.AsyncTask;
import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class CheckResults extends AsyncTask<Void, Void, Void> {

    private final String[] calcul;

    private final int[] result = new int[10];

    public CheckResults(String[] calcul) {
        this.calcul = calcul;
        Log.d("calcul", Arrays.toString(calcul));
    }

    public int[] getResult() {
        for (int i = 0; i < 10; i++) {
            Log.d("results encore", result[i] + "");
        }
        return result;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        String query = "http://api.mathjs.org/v4/";

        try {
            URL obj = new URL(query);
            HttpURLConnection postConnection = null;
            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");
            StringBuilder POST_PARAMS = new StringBuilder("{" + "\"expr\": [");
            for (int i = 0; i < calcul.length; i++) {
                calcul[i] = calcul[i].replaceAll("\\s+", "");
                POST_PARAMS.append("\"").append(calcul[i]).append("\"");
                if (i != calcul.length - 1) {
                    POST_PARAMS.append(", ");
                }
            }
            POST_PARAMS.append("]}");

            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.write(POST_PARAMS.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = postConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String test = response.toString();
                Log.d("reponse", test);
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(test);
                JSONArray jsonArray = (JSONArray) jsonObject.get("result");
                int[] finalResult = new int[10];
                for (int i = 0; i < jsonArray.size(); i++) {
                    String number = (String) jsonArray.get(i);
                    Log.d("jsonarray", jsonArray.get(i) + "");
                    if (!number.contains("."))
                        finalResult[i] = Integer.parseInt(number);
                    else {
                        double cast = Double.parseDouble(number);
                        finalResult[i] = (int) cast;
                    }
                }
                for (int i = 0; i < 10; i++) {
                    result[i] = finalResult[i];
                    Log.d("results", finalResult[i] + "");
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
