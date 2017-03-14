package com.jpuyo.android.memoryleaksplayground.presentation;

import com.jpuyo.android.memoryleaksplayground.domain.bo.Password;
import com.jpuyo.android.memoryleaksplayground.domain.datastore.PasswordDataStore;

/**
 * Created by usuario on 14/03/2017.
 */

class SavePasswordPresenter {

    private SavePasswordView view;
    private final PasswordDataStore passwordDataStore;

    public SavePasswordPresenter(PasswordDataStore passwordDataStore) {
        this.passwordDataStore = passwordDataStore;
    }

    public void setView(SavePasswordView savePasswordView) {
        this.view = savePasswordView;
    }

    public void savePassword(String newPassword) {
        Password password = new Password(newPassword);
        passwordDataStore.savePassword(password);
        view.onSavePasswordSuccess(passwordDataStore.getPassword());
    }

    public void getCurrentPassword() {
        Password password = passwordDataStore.getPassword();
        view.showPassword(password);
    }
}
