package ch.bbw.jl.idunno.dao;

import ch.bbw.jl.idunno.entity.DadJoke;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DadJokeDao {

    private static final String BASE_URL = "https://icanhazdadjoke.com/";

    public static DadJoke requestRandomDadJoke() {
        DadJoke dadJoke = null;
        try {
            StringBuilder url = new StringBuilder(BASE_URL);
            HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
            con.setRequestProperty("Accept", "application/json");

            int respCode = con.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                Gson gson = new Gson();
                dadJoke = gson.fromJson(reader, DadJoke.class);
            } else {
                System.out.println("Error: " + con);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return dadJoke;
    }
}
