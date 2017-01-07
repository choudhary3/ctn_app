package com.test.ctn;

/**
 * Created by rajat on 07-01-2017.
 */

public class personDetails {
    private String name;
    final private String password;
    private long mobno;
    public personDetails(String nam1,String pass,long mobile){
        name = nam1;
        password = pass;
        mobno = mobile;
    }
    public String getName(){
        return name;
    }
    public long getmobno(){
        return mobno;
    }

}
