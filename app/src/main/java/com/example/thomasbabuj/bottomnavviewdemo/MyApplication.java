package com.example.thomasbabuj.bottomnavviewdemo;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by thomasbabuj on 30/12/17.
 */

public class MyApplication extends Application {
    public static final String APP_LOG = MyApplication.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if the tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? APP_LOG : tag );
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(APP_LOG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequest(Object tag) {
        if(mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
