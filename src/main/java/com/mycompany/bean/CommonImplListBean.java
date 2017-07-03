package com.mycompany.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Created by starfucker on 03/07/2017.
 * List container implementation
 */

@JsonSerialize
public final class CommonImplListBean<T> extends CommonAbstractDataBean<List<T>> {
    public CommonImplListBean() {

    }
}
