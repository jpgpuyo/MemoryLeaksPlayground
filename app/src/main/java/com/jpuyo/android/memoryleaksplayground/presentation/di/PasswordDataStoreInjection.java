package com.jpuyo.android.memoryleaksplayground.presentation.di;

import android.content.Context;

import com.jpuyo.android.memoryleaksplayground.data.password.datastore.NoSingletonPasswordDataStore;
import com.jpuyo.android.memoryleaksplayground.data.password.datastore.SingletonPasswordDataStore;
import com.jpuyo.android.memoryleaksplayground.domain.datastore.PasswordDataStore;

/**
 * Created by usuario on 14/03/2017.
 */

public class PasswordDataStoreInjection {

    public static PasswordDataStore noSingletonWithActivityContext(Context context) {
        return new NoSingletonPasswordDataStore(context);
    }

    public static PasswordDataStore noSingletonWithApplicationContext(Context context) {
        return new NoSingletonPasswordDataStore(context.getApplicationContext());
    }

    public static PasswordDataStore singletonWithActivityContext(Context context) {
        return SingletonPasswordDataStore.getInstance(context);
    }

    public static PasswordDataStore singletonWithApplicationContext(Context context) {
        return SingletonPasswordDataStore.getInstance(context.getApplicationContext());
    }
}
