package com.jpuyo.android.memoryleaksplayground.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jpuyo.android.memoryleaksplayground.R;
import com.jpuyo.android.memoryleaksplayground.domain.bo.Password;
import com.jpuyo.android.memoryleaksplayground.domain.datastore.PasswordDataStore;
import com.jpuyo.android.memoryleaksplayground.presentation.di.PasswordDataStoreInjection;

public class SavePasswordActivity extends AppCompatActivity implements SavePasswordView {

    private EditText passwordInput;

    private Button savePasswordButton;

    private Button showPasswordButton;

    private SavePasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);

        injectViews();

        initializePresenter();

        setListeners();
    }

    private void injectViews() {
        passwordInput = (EditText) findViewById(R.id.password);
        savePasswordButton = (Button) findViewById(R.id.button_save_password);
        showPasswordButton = (Button) findViewById(R.id.button_show_password);
    }

    private void initializePresenter() {
        //PasswordDataStore passwordDataStore = PasswordDataStoreInjection.noSingletonWithActivityContext(this);
        //PasswordDataStore passwordDataStore = PasswordDataStoreInjection.noSingletonWithApplicationContext(this);
        //PasswordDataStore passwordDataStore = PasswordDataStoreInjection.singletonWithActivityContext(this);
        PasswordDataStore passwordDataStore = PasswordDataStoreInjection.singletonWithApplicationContext(this);

        presenter = new SavePasswordPresenter(passwordDataStore);
        presenter.setView(this);
    }

    private void setListeners() {
        savePasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.savePassword(passwordInput.getText().toString());
            }
        });
        showPasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getCurrentPassword();
            }
        });
    }

    @Override
    public void onSavePasswordSuccess(Password password) {
        Toast.makeText(this, getString(R.string.save_password_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPassword(Password password) {
        Toast.makeText(this, password.getPassword(), Toast.LENGTH_SHORT).show();
    }
}

