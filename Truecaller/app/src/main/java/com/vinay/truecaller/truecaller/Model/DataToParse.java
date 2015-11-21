package com.vinay.truecaller.truecaller.Model;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class DataToParse {

    private String data;
    private int n;

    public DataToParse(String data, int n){
        this.data = data;
        this.n = n;
    }

    public String getData() {
        return data;
    }

    public int getN() {
        return n;
    }
}
