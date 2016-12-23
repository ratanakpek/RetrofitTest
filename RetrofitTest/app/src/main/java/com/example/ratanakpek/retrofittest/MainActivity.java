package com.example.ratanakpek.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ratanakpek.retrofittest.dao.User;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tvshow);

    }

    public void retrof(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.136.24.174:1301/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //getapi interface
        getapi service = retrofit.create(getapi.class);
        Call<User> call = service.getStudentDetails();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                try {
                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                tv.setText("ERror");
                Log.d("onFailure", t.toString());
            }
        });

    }



    public void getData(View view) {
        retrof();
    }
}
