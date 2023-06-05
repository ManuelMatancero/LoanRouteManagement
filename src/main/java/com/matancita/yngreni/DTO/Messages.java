package com.matancita.yngreni.DTO;

import lombok.Data;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
@Data
public class Messages {
    private String message;

    public Messages(){};
    public Messages(String message){
        this.message = message;
    }
}
