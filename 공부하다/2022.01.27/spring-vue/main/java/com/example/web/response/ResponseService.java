package com.example.web.response;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {

	public <T> SingleResponseData<T> getResponseData(T item) {
        SingleResponseData<T> responseData = new SingleResponseData<>();
        responseData.setItem(item);
        responseData.setSuccess(true);
        return responseData;
    }

    public <T> ListResponseData<T> getResponseData(List<T> items) {
        ListResponseData<T> responseData = new ListResponseData<>();
        responseData.setItems(items);
        responseData.setSuccess(true);
        return responseData;
    }

    public ResponseData getSuccessResponse() {
        return getResponseData(true);
    }

    public ResponseData getFailResponse(String message) {
        return getResponseData(false, message);
    }

    private ResponseData getResponseData(boolean success, String message) {
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(success);
        return responseData;
    }
	
    
}
