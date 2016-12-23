package com.example.advancecourse.homework;

import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.annotations.RegExp;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //@MinLength(value = 5, messageId = R.string.validation_name_length, order = 1)
    @NotEmpty(messageId = R.string.validation_name, order = 1)
    @RegExp(value = "^[A-Za-z0-9+_.-]+@(.+)$", messageId = R.string.validation_valid_email)
    private EditText mNameEditText;

    @MinLength(value = 3, messageId = R.string.validation_name_length, order = 1)
    @NotEmpty(messageId = R.string.validation_name, order = 1)
    private EditText mPassword;


    Button btnSignin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEditText = (EditText) findViewById(R.id.edtEmail);
        mPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(this);
       // Intent go = new Intent(this, DashBoard.class);
       // startActivity(go);
    }

    public void doValidation(String email, String password) {
        Log.d("validation", email + "->" + password);
        if (email.equals("ratanak@gmail.com") && password.equals("123")) {
            Intent dashboard = new Intent(this, DashBoard.class);
            startActivity(dashboard);

        } else {
            MyDialog dialog = new MyDialog();
            dialog.show(getFragmentManager(), "Dialog");

        }
    }

    private boolean validate() {
        long start = SystemClock.elapsedRealtime();
        final boolean isValid = FormValidator.validate(this, new SimpleErrorPopupCallback(this, true));
        long time = SystemClock.elapsedRealtime() - start;
        Log.d(getClass().getName(), "validation finished in [ms] " + time);
        if (isValid) {
            Toast.makeText(getApplicationContext(), "Validation  ", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        //Check Email validation first before validation login
        if(validate()) {
            switch (btn.getId()) {
                case R.id.btnSignin:
                    doValidation(mNameEditText.getText().toString(), mPassword.getText().toString());
                    break;
                default:
                    Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
