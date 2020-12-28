package com.lzr.vo;

import java.util.List;

public class YearTj {
    /*财务统计*/
    private int year;
    private int month;
    private double money;
    private List<YearTj> zhichus;
    private List<YearTj> shourus;
    private List<YearTj> xiaoshous;
    private List<YearTj> shshrs;
    /*销售统计*/
    private int number;//销售多少件
    //商户id
    private int shid;

    public YearTj(){}

    public YearTj(int year, int month, double money, List<YearTj> zhichus, List<YearTj> shourus, List<YearTj> xiaoshous, List<YearTj> shshrs, int number, int shid) {
        this.year = year;
        this.month = month;
        this.money = money;
        this.zhichus = zhichus;
        this.shourus = shourus;
        this.xiaoshous = xiaoshous;
        this.shshrs = shshrs;
        this.number = number;
        this.shid = shid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<YearTj> getZhichus() {
        return zhichus;
    }

    public void setZhichus(List<YearTj> zhichus) {
        this.zhichus = zhichus;
    }

    public List<YearTj> getShourus() {
        return shourus;
    }

    public void setShourus(List<YearTj> shourus) {
        this.shourus = shourus;
    }

    public List<YearTj> getXiaoshous() {
        return xiaoshous;
    }

    public void setXiaoshous(List<YearTj> xiaoshous) {
        this.xiaoshous = xiaoshous;
    }

    public List<YearTj> getShshrs() {
        return shshrs;
    }

    public void setShshrs(List<YearTj> shshrs) {
        this.shshrs = shshrs;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
    }

    @Override
    public String toString() {
        return "YearTj{" +
                "year=" + year +
                ", month=" + month +
                ", money=" + money +
                ", zhichus=" + zhichus +
                ", shourus=" + shourus +
                ", xiaoshous=" + xiaoshous +
                ", shshrs=" + shshrs +
                ", number=" + number +
                ", shid=" + shid +
                '}';
    }
}
