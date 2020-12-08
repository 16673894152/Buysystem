package com.lzr.utils;

public class ShuJuZhuanhuan {
    public static Integer[] stringToIntArr(String [] arr){
        Integer [] integers = new Integer[arr.length];
        for (int i = 0;i < arr.length;i ++){
            integers[i] = Integer.parseInt(arr[i]);
        }
        return integers;
    }
}
