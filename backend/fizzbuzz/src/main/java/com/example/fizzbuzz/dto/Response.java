package com.example.fizzbuzz.dto;

public class Response {

    CreateResultResponse createResultResponse;
    CreateResultError createResultError;

    public CreateResultResponse getCreateResultResponse() {
        return createResultResponse;
    }

    public void setCreateResultResponse(CreateResultResponse createResultResponse) {
        this.createResultResponse = createResultResponse;
    }

    public CreateResultError getCreateResultError() {
        return createResultError;
    }

    public void setCreateResultError(CreateResultError createResultError) {
        this.createResultError = createResultError;
    }
}
