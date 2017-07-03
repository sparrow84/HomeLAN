package com.mycompany.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by starfucker on 03/07/2017.
 * General essence interface
 */

@JsonSerialize
public interface CommonBean<T> {
    T getData();

    void setData(T data);
}
