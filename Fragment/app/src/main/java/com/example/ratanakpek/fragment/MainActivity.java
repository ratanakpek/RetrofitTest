package com.example.ratanakpek.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator{
    FragmentA a;
    FragmentB b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new FragmentA();
        b = new FragmentB();


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fa, a);
        ft.add(R.id.fb, b);
        ft.commit();
    }

    @Override
    public void reponse(int data) {
        String objAnswer[] =getResources().getStringArray(R.array.answer);
        Toast.makeText(this, "Value : "+objAnswer[data] ,  Toast.LENGTH_SHORT).show();
        b.changeText(objAnswer[data]);

    }
}
