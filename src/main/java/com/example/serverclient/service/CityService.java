package com.example.serverclient.service;


import com.example.serverclient.entity.CityEntity;
import com.example.serverclient.properties.ClientProperties;
import com.example.serverclient.response.BaseResponse;
import com.example.serverclient.response.DataResponse;
import com.example.serverclient.response.ListResponse;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;

public class CityService {
    @Getter
    private ObservableList data = FXCollections.observableArrayList();
    private final HttpService http = new HttpService();
    JsonService service = new JsonService();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResponse<CityEntity>>() {
    }.getType();
    private Type listType = new TypeToken<DataResponse<CityEntity>>() {
    }.getType();
    public void getAll() {
        ListResponse data = new ListResponse();
        data = service.getObject(http.get(prop.getAllCity()), listType);
        if (data.isSuccess()) {
            this.data.addAll(data.getData());
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
    }
    public void add(CityEntity data) {
        String temp = http.post(prop.getSaveCity(), service.getJson(data));
        DataResponse response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
    public void update(CityEntity data) {
        String temp = http.put(prop.getUpdateCity(), service.getJson(data));
        DataResponse response = service.getObject(temp,dataType);
        if (response.isSuccess()) {
            this.data.remove(data);
            this.data.add(response.getData());
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
    //TODO дописать на сервере
    public void delete(CityEntity data) {
        String temp = http.delete(prop.getDeleteCity(), data.getId());
        BaseResponse response = service.getObject(temp, BaseResponse.class);
        if (response.isSuccess()) {
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
    //TODO дописать
    public void findById(CityEntity data) {
        String temp = http.get(prop.getFineByIdCity() + data.getId());
        DataResponse response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
