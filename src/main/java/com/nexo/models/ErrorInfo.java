package com.nexo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.client.ResponseErrorHandler;

public class ErrorInfo {
    @JsonProperty("message")
    private String message;

    @JsonProperty("statusCode")
    private int statusCode;

    @JsonProperty("uri")
    private String uriRequested;

    public ErrorInfo(InvalidDataAccessApiUsageException exception, String uriRequested) {
        this.message = exception.getMessage();
        this.statusCode = exception.hashCode();
        this.uriRequested = uriRequested;
    }

    public ErrorInfo(int statusCode, String message, String uriRequested) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUriRequested() {
        return this.uriRequested;
    }
}
