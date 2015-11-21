package com.vinay.truecaller.truecaller.RequestManager;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.vinay.truecaller.truecaller.Parser.Parser;
import com.vinay.truecaller.truecaller.Parser.ParserFactory;
import com.vinay.truecaller.truecaller.Parser.ParserType;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class TrueCallerStringRequest extends StringRequest{

    private final Response.Listener<String> listener;
    private ParserType parserType;

    /**
     * Creates a new request with the given method.
     *
     * @param method        the request {@link Method} to use
     * @param url           URL to fetch the string at
     * @param listener      Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public TrueCallerStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener, ParserType parserType) {
        super(method, url, listener, errorListener);
        this.listener = listener;
        this.parserType = parserType;
    }

    /**
     * Creates a new GET request.
     *
     * @param url           URL to fetch the string at
     * @param listener      Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public TrueCallerStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener, ParserType parserType) {
        super(url, listener, errorListener);
        this.listener = listener;
        this.parserType = parserType;
    }

    @Override
    protected void deliverResponse(String response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {

        Parser dataParser = null;
        String dataString = new String(response.data);

        switch(parserType)
        {
            case TENTH_CHARACTER_PARSER:
                dataParser = ParserFactory.GetParser(ParserType.TENTH_CHARACTER_PARSER);
                if(dataParser != null){
                    dataParser.setDataToParse(dataString, 10);
                    dataString = dataParser.getResult();
                }
                break;
            case EVERY_TENTH_CHARACTER_PARSER:
                dataParser = ParserFactory.GetParser(ParserType.EVERY_TENTH_CHARACTER_PARSER);
                if(dataParser != null){
                    dataParser.setDataToParse(dataString, 10);
                    dataString = dataParser.getResult();
                }
                break;
            case WORD_COUNT_PARSER:
                dataParser = ParserFactory.GetParser(ParserType.WORD_COUNT_PARSER);
                if(dataParser != null){
                    dataParser.setDataToParse(dataString, -1);
                    dataString = dataParser.getResult();
                }
                break;
            default:
                break;
        }


        return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
    }
}
