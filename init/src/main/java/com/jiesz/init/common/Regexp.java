package com.jiesz.init.common;


public class Regexp {
    public static final String PWD = "^(?![^a-zA-Z]+$)(?!\\D+$).{8,}$";
    public static final String USERNAME = "^[a-z0-9A-Z]{5,20}$";
}
