package com.vinay.truecaller.truecaller.Parser;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class NthCountParser implements Parser {

    private String dataToParse;
    private int n = -1;

    @Override
    public void setDataToParse(String data, int n){
        dataToParse = data;
        this.n = n;
    }

    @Override
    public String getResult(){
        String result = null;
        if(dataToParse != null){
            result="";
            for(int i = n; i < dataToParse.length(); i = i + n){
                if(i != n){
                    result += ", ";
                }
                if(i < dataToParse.length()) {
                    result += dataToParse.charAt(i);
                }
            }
        }
        return result;
    }
}
