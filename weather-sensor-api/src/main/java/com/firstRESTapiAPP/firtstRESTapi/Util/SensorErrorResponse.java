package com.firstRESTapiAPP.firtstRESTapi.Util;

public class SensorErrorResponse {
    private String msg;
    private  Long timestamp;

    public SensorErrorResponse(String msg, Long timestamp) {
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
