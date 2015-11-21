package com.vinay.truecaller.truecaller.RequestManager;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ing07444 on 8/8/2015.
 */
public class RequestQ {
    private static RequestQ requestQInstance;
    private static Context activityContext;
    private RequestQueue requestQueue;

    private RequestQ(Context context){
        activityContext = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized RequestQ getInstance(Context context) {
        if (requestQInstance == null) {
            requestQInstance = new RequestQ(context);
        }
        return requestQInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(activityContext.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
