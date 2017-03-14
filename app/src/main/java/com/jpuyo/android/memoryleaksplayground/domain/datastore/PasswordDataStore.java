package com.jpuyo.android.memoryleaksplayground.domain.datastore;

import com.jpuyo.android.memoryleaksplayground.domain.bo.Password;

/**
 * Created by usuario on 14/03/2017.
 */

public interface PasswordDataStore {
    Password getPassword();
    void savePassword(Password password);
}
