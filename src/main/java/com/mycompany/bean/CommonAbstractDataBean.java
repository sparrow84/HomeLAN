package com.mycompany.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by starfucker on 03/07/2017.
 * Data container abstraction
 */

@JsonSerialize
public abstract class CommonAbstractDataBean<T> implements CommonBean<T> {
    @JsonProperty(value = "data")
    private T data;

    CommonAbstractDataBean() {

    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}
