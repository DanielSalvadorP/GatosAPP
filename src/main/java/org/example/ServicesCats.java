package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ServicesCats {

    public static void showCats() throws IOException {
        // 1. traer lo datos de la api
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        elJson = elJson.substring(1,elJson.length());
        elJson = elJson.substring(0,elJson.length()-1);




    }
}
