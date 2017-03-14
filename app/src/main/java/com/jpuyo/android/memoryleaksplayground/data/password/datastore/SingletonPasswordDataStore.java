package com.jpuyo.android.memoryleaksplayground.data.password.datastore;

import android.content.Context;
import android.content.SharedPreferences;

import com.jpuyo.android.memoryleaksplayground.domain.bo.Password;
import com.jpuyo.android.memoryleaksplayground.domain.datastore.PasswordDataStore;

/**
 * Created by usuario on 14/03/2017.
 */

public class SingletonPasswordDataStore implements PasswordDataStore {

    private static SingletonPasswordDataStore INSTANCE;

    public static final String SESSION_PASSWORD = "session.password";
    public static final String SESSION = "session";

    private final Context context;

    public static SingletonPasswordDataStore getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SingletonPasswordDataStore(context);
        }
        return INSTANCE;
    }

    private SingletonPasswordDataStore(Context context) {
        this.context = context;
    }

    @Override
    public Password getPassword() {
        SharedPreferences preferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        String passwordStored = preferences.getString(SESSION_PASSWORD, "");
        return new Password(passwordStored);
    }

    @Override
    public void savePassword(Password password) {
        SharedPreferences preferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        preferences.edit()
                .putString(SESSION_PASSWORD, password.getPassword())
                .apply();
    }
}
