package com.vinay.truecaller.truecaller.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.vinay.truecaller.truecaller.Model.Constant;
import com.vinay.truecaller.truecaller.Parser.ParserType;
import com.vinay.truecaller.truecaller.R;
import com.vinay.truecaller.truecaller.RequestManager.RequestQ;
import com.vinay.truecaller.truecaller.RequestManager.TrueCallerStringRequest;

public class MainActivity extends AppCompatActivity {

    Button volleyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyButton = (Button)findViewById(R.id.startVolley);

        volleyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartVolleyClicked(v);
            }
        });
        RequestQ.getInstance(this).getRequestQueue().start();

    }

    public void onStartVolleyClicked(View v) {
        // Instantiate the RequestQueue.
        RequestQ queue = RequestQ.getInstance(this);
        String url = Constant.DESTINATION_URL;

        // Request a string response from the provided URL.
        final TrueCallerStringRequest stringRequest = new TrueCallerStringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView textView = (TextView)findViewById(R.id.textViewForChar);
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }, ParserType.TENTH_CHARACTER_PARSER);

        final TrueCallerStringRequest stringRequestNth = new TrueCallerStringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView textView = (TextView)findViewById(R.id.textViewForEveryTenth);
                        textView.setMovementMethod(new ScrollingMovementMethod());
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }, ParserType.EVERY_TENTH_CHARACTER_PARSER);

        final TrueCallerStringRequest stringRequestWordCount = new TrueCallerStringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView textView = (TextView)findViewById(R.id.textViewForWordCount);
                        textView.setMovementMethod(new ScrollingMovementMethod());
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }, ParserType.WORD_COUNT_PARSER);

        // Add the request to the RequestQueue.
        queue.addToRequestQueue(stringRequest);
        queue.addToRequestQueue(stringRequestNth);
        queue.addToRequestQueue(stringRequestWordCount);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
