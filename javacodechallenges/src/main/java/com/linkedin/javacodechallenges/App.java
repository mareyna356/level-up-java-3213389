package com.linkedin.javacodechallenges;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App {

    public static String parseJoke(String httpResponse) {
        try {
            Gson gson = (new GsonBuilder()).create();
            Joke joke = gson.fromJson(httpResponse, Joke.class);
            return joke.getJoke();
        } catch (Exception e) {
            System.out.println("Must be out of jokes for now.");
            return "";
        }
    }

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://icanhazdadjoke.com/"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(parseJoke(response.body()));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
