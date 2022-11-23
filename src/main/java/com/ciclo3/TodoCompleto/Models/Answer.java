package com.ciclo3.TodoCompleto.Models;

public class Answer {
    private Object Object;
    private String message;

    public Answer() {
    }

    public Answer(String message, Object object) {
        Object = object;
        this.message = message;
    }

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
