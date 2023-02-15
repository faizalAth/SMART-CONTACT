package com.smart.contact.helper;

public class Helper {
    private String message;
    private String msg_type;
    public String getMessage() {
        return message;
    }
    public String getMsg_type() {
        return msg_type;
    }
    public Helper(String message, String msg_type) {
        this.message = message;
        this.msg_type = msg_type;
    }

    
}
