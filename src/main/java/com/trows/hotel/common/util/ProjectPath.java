package com.trows.hotel.common.util;

/**
 * Created by Throws_exception on 2015/7/23.
 */
public class ProjectPath {
    private static String path =setPath();
    private static String setPath (){
       path = System.getProperty("user.dir");
        path = path.substring(0,path.length()-4)+"\\webapps\\hotel\\file";
        return path;
    }
    public static String getPath(){
        return path;
    }
}
