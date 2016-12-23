package com.example.ratanakpek.sqllitedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ratanakpek.sqllitedemo.R.id.contentPanel;
import static com.example.ratanakpek.sqllitedemo.R.id.edtUsername;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    MyDbHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.edtUsername);
        password = (EditText) findViewById(R.id.edtPassword);
        dbhelper=new MyDbHelper(this);
    }

    public void onInsert(View view) {
        String user=username.getText().toString();
        String pass = password.getText().toString();

        long id =dbhelper.insertData(user, pass);
            if(id<0){
               Message.message(this, "Unsuccessfully!");
            }else{
                Message.message(this, "Successfully!");
            }
    }

    public void viewData(View view) {
        String data =dbhelper.SelectData();
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

    public void onselect(View view) {
        String user=username.getText().toString();
        String pass = password.getText().toString();
        if(!user.equals("")&&!pass.equals("")){
            String d=dbhelper.selectByName(user, pass);
            if(!d.equals("")) {
                Message.message(this, d);
            }else{
                Message.message(this , "No have in db");
            }

        }else{
            Message.message(this, "Can not empty!");
        }


    }

    public void onDelete(View view) {
        String user=username.getText().toString();

        if(!user.equals("")){
            String data =dbhelper.delete(user);
            Message.message(this, data);
        }else{
            Message.message(this, "Username can not be empty.");
        }
    }

    public void onUpdate(View view) {
        String user=username.getText().toString();
        String pass = password.getText().toString();
        if(!user.equals("")){
            String data =dbhelper.update(user, pass);
            Message.message(this, data);
        }else{
            Message.message(this, "Username can not be empty.");
        }
    }
}
