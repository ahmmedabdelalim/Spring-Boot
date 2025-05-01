package com.lemo.demo.Exception;

public class StudentErorrResponse {

    private int status;
    private String message;
    private long timeSatmp;

    public StudentErorrResponse() {
        this.status = status;
        this.message = message;
        this.timeSatmp = timeSatmp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeSatmp() {
        return timeSatmp;
    }

    public void setTimeSatmp(long timeSatmp) {
        this.timeSatmp = timeSatmp;
    }
}
