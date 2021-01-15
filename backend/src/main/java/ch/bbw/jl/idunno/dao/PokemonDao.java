package ch.bbw.jl.idunno.dao;

import ch.bbw.jl.idunno.entity.DadJoke;
import ch.bbw.jl.idunno.entity.Pokemon;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PokemonDao {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    public static List<Pokemon> requestPokemonList() {
        List<Pokemon> pokemonList = null;
        try {
            StringBuilder url = new StringBuilder(BASE_URL);
            HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
            con.setRequestProperty("Accept", "application/json");

            int respCode = con.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                Gson gson = new Gson();
                pokemonList = gson.fromJson(reader, (Type) Pokemon.class);
            } else {
                System.out.println("Error: " + con);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }

    public static Pokemon getPokemonById(int id) {
        Pokemon pokemon = null;
        try {
            StringBuilder url = new StringBuilder(BASE_URL + "/" + id);
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
            con.setRequestProperty("Accept", "application/json");

            int respCode = con.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                Gson gson = new Gson();
                pokemon = gson.fromJson(reader, Pokemon.class);
            } else {
                System.out.println("Error: " + con);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return pokemon;
    }
}
