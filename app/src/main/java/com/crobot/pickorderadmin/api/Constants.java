package com.crobot.pickorderadmin.api;

import com.crobot.pickorderadmin.utils.Decript;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class Constants {
    public static final String URL="https://d.apicloud.com/mcm/api/";
    public static final String APPID="A6913868279394";
    public static final String APPKEY= "93FED152-544D-9058-6DDE-A8EF14FDA419";
    public static final int INIT_LIST_LENGTH = 16;

    public static String getAppkey(){
        long now = new Date().getTime();
        return Decript.SHA1(Constants.APPID + "UZ" + Constants.APPKEY + "UZ" + now) + "." + now;
    }


}
