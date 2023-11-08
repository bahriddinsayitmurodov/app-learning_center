package com.java.bahriddin.applearningcenter.enums;

public enum Role {

    ADMIN(1),
    MANAGER(2),
    MENTOR(3),
    STUDENT(4);
    private final Integer code;
    Role(Integer code){
        this.code = code;
    }

}