package com.example.ratanakpek.fragmenttestagain;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator {
    FragmentB b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentA a = new FragmentA();
        b = new FragmentB();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fa, a);
        ft.add(R.id.fb, b);
        ft.addToBackStack("a");
        ft.addToBackStack("a");
        ft.commit();
    }

    @Override
    public void response(int i) {
        String objA[] = getResources().getStringArray(R.array.a);
        Toast.makeText(this, objA[i], Toast.LENGTH_SHORT).show();
        b.setText(objA[i]);
    }
}
