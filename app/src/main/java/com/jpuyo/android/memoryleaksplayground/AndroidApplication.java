package com.jpuyo.android.memoryleaksplayground;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by usuario on 15/03/2017.
 */

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
