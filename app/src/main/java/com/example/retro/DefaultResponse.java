package com.example.retro;

public class DefaultResponse {
    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DefaultResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
