package com.example.advancecourse.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

/**
 * Created by RatanakPek on 11/16/2016.
 */

public class AddProduct extends Activity  {
    @MinLength(value = 3, messageId = R.string.validation_name_length, order = 1)
    @NotEmpty(messageId = R.string.validation_name, order = 1)
    private EditText pName;

    @MinLength(value = 10, messageId = R.string.validation_name_length_desc, order = 2)
    @NotEmpty(messageId = R.string.validation_name, order = 2)
    private EditText pDesc;

    @MinLength(value = 1, messageId = R.string.validation_name_length, order = 3)
    @NotEmpty(messageId = R.string.validation_name, order = 3)
    private EditText pViews;


    Button bCancel, bAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_products);
        pName= (EditText) findViewById(R.id.pName);
        pDesc= (EditText) findViewById(R.id.pDesc);
        pViews= (EditText) findViewById(R.id.pView);
        bCancel= (Button) findViewById(R.id.pCancel);
        bAdd= (Button) findViewById(R.id.pAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                Toast.makeText(AddProduct.this, "Send data back", Toast.LENGTH_SHORT).show();

            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddProduct.this, "Go Back", Toast.LENGTH_SHORT).show();
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
                finish();
            }
        });

    }
    private void validate() {
        long start = SystemClock.elapsedRealtime();
        final boolean isValid = FormValidator.validate(this, new SimpleErrorPopupCallback(this, true));
        long time = SystemClock.elapsedRealtime() - start;
        Log.d(getClass().getName(), "validationddddxxx finished in [ms] " + time);
        if (isValid) {
            Toast.makeText(getApplicationContext(), "Validation  ", Toast.LENGTH_SHORT).show();

            Intent returnData= new Intent();
            returnData.putExtra("Title", pName.getText().toString());
            returnData.putExtra("Descrip", pDesc.getText().toString());
            returnData.putExtra("Views", pViews.getText().toString());
            setResult(2, returnData);
            Toast.makeText(AddProduct.this, "Send data back", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
