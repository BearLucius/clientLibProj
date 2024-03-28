package com.example.serverclient.service;

import com.example.serverclient.entity.AuthorEntity;
import com.example.serverclient.properties.ClientProperties;
import com.example.serverclient.response.BaseResponse;
import com.example.serverclient.response.DataResponse;
import com.example.serverclient.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class AuthorService {
    @Getter
    private ObservableList data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<AuthorEntity>>() {
    }.getType();
    private Type listType = new TypeToken<DataResponse<AuthorEntity>>() {
    }.getType();
    public void getAll() {
        ListResponse data = new ListResponse();
        data = service.getObject(http.get(prop.getAllAuthor()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }
    public void add(AuthorEntity data) {
        String temp = http.post(prop.getSaveAuthor(), service.getJson(data));
        DataResponse response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
    public void update(AuthorEntity data) {
        String temp = http.put(prop.getUpdateAuthor(), service.getJson(data));
        DataResponse response = service.getObject(temp,dataType);
        if (response.isSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
    //TODO дописать на сервере
    public void delete(AuthorEntity data) {
        String temp = http.delete(prop.getDeleteAuthor(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
    //TODO дописать
    public void findById(AuthorEntity data) {
        String temp = http.get(prop.getFineByIdAuthor() + data.getId());
        DataResponse response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
