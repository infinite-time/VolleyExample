package com.vinay.truecaller.truecaller.Parser;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class ParserFactory {
    public static Parser GetParser(ParserType parserType){
        Parser parser = null;
        switch(parserType){
            case TENTH_CHARACTER_PARSER:
                parser = new NthCharacterParser();
                break;
            case EVERY_TENTH_CHARACTER_PARSER:
                parser = new NthCountParser();
                break;
            case WORD_COUNT_PARSER:
                parser = new WordCountParser();
                break;
            default:
                break;
        }
        return parser;
    }
}
