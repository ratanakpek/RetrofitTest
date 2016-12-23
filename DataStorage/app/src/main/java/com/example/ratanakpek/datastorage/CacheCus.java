package com.example.ratanakpek.datastorage;

import android.app.Activity;
import android.os.Bundle;

import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 * Created by RatanakPek on 11/16/2016.
 */

public class CacheCus extends Activity {
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache);
        username= (EditText) findViewById(R.id.edtUsername);
    }

    public void internalCache(View view){
        String data = username.getText().toString();
        File folder = getCacheDir();
        File file = new File(folder, "internalcache.txt");
        writeData(data, file);
    }

    private void writeData(String data, File file){
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(file);
            fos.write(data.getBytes());
            Toast.makeText(this, "Url"+file.getAbsolutePath(), Toast.LENGTH_LONG).show();
            username.setText(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void externalPrivate(View v){
        String data = username.getText().toString();
        File folder = getExternalFilesDir("datastorage");
        File file =new File(folder, "externalPrivate.txt");
        writeData(data, file);

    }
    public void externalPublic(View v){
        String data = username.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "externalPublic.txt");
        writeData(data, file);
    }
    public void externalCache(View v){
        String data = username.getText().toString();
        File folder = getExternalCacheDir();
        File file = new File(folder, "externalPrivate.txt");
        writeData(data, file);
    }


}
