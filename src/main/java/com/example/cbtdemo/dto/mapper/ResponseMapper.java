package com.example.cbtdemo.dto.mapper;

import com.example.cbtdemo.controller.request.ResponseRequest;
import com.example.cbtdemo.dto.ResponseDto;
import com.example.cbtdemo.model.Response;

public class ResponseMapper {
    public static Response toResponse(ResponseRequest responseRequest){
        return new Response()
                .setResponse(responseRequest.getResponse());
    }

    public static ResponseDto toDto(Response response){
        return new ResponseDto()
                .setResponse(response.getResponse());
    }
}
