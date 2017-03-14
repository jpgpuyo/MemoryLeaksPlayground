package com.jpuyo.android.memoryleaksplayground.presentation;

import com.jpuyo.android.memoryleaksplayground.domain.bo.Password;

/**
 * Created by usuario on 14/03/2017.
 */

interface SavePasswordView {
    void onSavePasswordSuccess(Password password);
    void showPassword(Password password);
}
