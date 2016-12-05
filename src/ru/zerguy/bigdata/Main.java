package ru.zerguy.bigdata;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static final String KEY = "18A4FFCA6F72D1EB21FE386E521D1695";
    public static final String STEAM_ID = "76561198023043869";

    public static void main(String[] args) throws IOException {
        String url = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=18A4FFCA6F72D1EB21FE386E521D1695&steamids=76561198023043869";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result);

    }
}
