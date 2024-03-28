package com.example.serverclient.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> extends BaseResponse {
    private T data;
    public DataResponse(boolean succes, String message, T data){
        super(succes,message);
        this.data=data;
    }
}
