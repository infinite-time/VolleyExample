package com.vinay.truecaller.truecaller.Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class WordCountParser implements Parser{

    private String dataToParse;
    private int n = -1;

    @Override
    public void setDataToParse(String data, int n) {
        dataToParse = data;
    }

    @Override
    public String getResult() {
        Map<String, Integer> countByWords = new HashMap<String, Integer>();
        Scanner s = new Scanner(dataToParse);
        while (s.hasNext()) {
            String next = s.next();
            if (countByWords.containsKey(next)) {
                countByWords.put(next, countByWords.get(next) + 1);
            } else {
                countByWords.put(next, 1);
            }
        }
        s.close();
        return countByWords.toString();
    }
}
