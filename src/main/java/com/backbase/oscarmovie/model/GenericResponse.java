package com.backbase.oscarmovie.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private Integer status;
    private String message;
    private Boolean success;

    public GenericResponse(Integer status, String message, Boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericResponse that = (GenericResponse) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(message, that.message) &&
                Objects.equals(success, that.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, success);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

