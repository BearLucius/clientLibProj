package edu.bip.clientlibproj.clientlibproj.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.bip.clientlibproj.clientlibproj.Entity.BookEntity;
import edu.bip.clientlibproj.clientlibproj.response.BaseResponse;
import edu.bip.clientlibproj.clientlibproj.response.BookListResponse;
import okhttp3.*;

import java.io.IOException;



public class HTTPUtils {
    OkHttpClient client = new OkHttpClient();

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    public BaseResponse post(String url, BookEntity book) throws IOException {
        System.out.println(url);
        RequestBody body = RequestBody.create(gson.toJson(book), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(body).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code" + response);
            return  gson.fromJson(response.body().string(), BaseResponse.class);
        }
    }

    public BookListResponse get(String url, String  args) throws IOException {
        Request req = new Request.Builder().url(url + args).build();
        try (Response response = client.newCall(req).execute()) {
            BookListResponse book = new BookListResponse();
            book = gson.fromJson(response.body().string(), BookListResponse.class);
            return book;
        }
    }

    public String put(String url, String json) throws IOException {
        RequestBody req = new RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(body).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
    }
    }


    public boolean get(String url) {
        return false;
    }
}
