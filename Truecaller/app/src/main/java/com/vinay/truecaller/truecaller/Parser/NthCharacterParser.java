package com.vinay.truecaller.truecaller.Parser;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class NthCharacterParser implements Parser {

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
        Character nthCharacter = dataToParse.charAt(n);
        return Character.toString(nthCharacter);
    }
}
