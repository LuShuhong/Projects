package com.thg.accelerator;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BuildDTO {

    private long id;
    private String msg;


    public BuildDTO() {}

    public BuildDTO(long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
