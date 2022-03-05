package com.lucasmercier.superhero.feature.common.service;

import com.google.gson.Gson;
import com.lucasmercier.superhero.feature.common.contract.HttpClientServiceContract;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class OkHttpClientService implements HttpClientServiceContract {

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    public <T, S> T post(String url, S data, T emptyInstance) {
        return null;
    }

    @Override
    public <T> T get(String url, Class<T> tClass) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            String jsonResponse = Objects.requireNonNull(response.body()).string();
            return new Gson().fromJson(jsonResponse, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
