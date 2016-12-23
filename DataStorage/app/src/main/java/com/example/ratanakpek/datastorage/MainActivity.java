package com.example.ratanakpek.datastorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    SharedPreferences sharedPreferences;
    public static final String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("credential", Context.MODE_PRIVATE);
        Intent go = new Intent(this, CacheCus.class);
        startActivity(go);
    }
    public void onLoad(View v){
        String name=sharedPreferences.getString("username", DEFAULT);
        String pass= sharedPreferences.getString("password", DEFAULT);
        if(name.equals(DEFAULT)||pass.equals(DEFAULT)){
            Toast.makeText(this, "Data was not found!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Username --> "+ name +"\n" +
                "Password --> "+pass, Toast.LENGTH_SHORT).show();

    }

    public void onSave(View v){
        SharedPreferences.Editor editor  =sharedPreferences.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data was save successfully!", Toast.LENGTH_SHORT).show();

    }

    public void onFileSave(View v) throws IOException {
        String uName=username.getText().toString()+" ";
        String uPass = password.getText().toString();
        File file =null;
        FileOutputStream fileOutputStream=null;
        try {
            file=getFilesDir();
            fileOutputStream= openFileOutput("credential", Context.MODE_PRIVATE);
            fileOutputStream.write(uName.getBytes());
            fileOutputStream.write(uPass.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
        Toast.makeText(this, "Directory : "+file +". Save successfully!", Toast.LENGTH_LONG).show();
    }
    public void onLoadFile(View v){
        FileInputStream fileRead=null;
        try {
            fileRead=openFileInput("credential");
          StringBuffer buffer
                  =new StringBuffer();
            int data= -1;
           while((data=fileRead.read())!=-1){
                buffer.append((char)data);
           }

            //get data from file
            String loadName=buffer.substring(0, buffer.indexOf(" "));
            String loadPass = buffer.substring(buffer.indexOf(" ")+1);

            username.setText(loadName);
            password.setText(loadPass);

            Toast.makeText(this, "Data : Successful", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
