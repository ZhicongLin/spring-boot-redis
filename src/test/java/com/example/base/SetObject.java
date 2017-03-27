package com.example.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zc.lin on 2017/3/27.
 */
@Setter
@Getter
public class SetObject implements Serializable {

    private long id;
    private String name;
}
