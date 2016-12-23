package com.example.ratanakpek.arrayadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ArrayList<Hotel> obj=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        obj.add(new Hotel("123","wook", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));

        obj.add(new Hotel("111","yoona", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("432","download", "Sunway Hotel", "We you want to contact use you want to contact use you want to contact use are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("432","download", "Sunway Hotel", "We you want to contact use you want to contact use you want to contact use are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("123","wook", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));

        obj.add(new Hotel("111","yoona", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("432","download", "Sunway Hotel", "We you want to contact use you want to contact use you want to contact use are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("432","download", "Sunway Hotel", "We you want to contact use you want to contact use you want to contact use are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("123","wook", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));

        obj.add(new Hotel("111","yoona", "Sunway Hotel", "We are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));
        obj.add(new Hotel("432","download", "Sunway Hotel", "We you want to contact use you want to contact use you want to contact use are the best hotel in Cambodia so if" +
                "you want to contact use, please feel free to contact now", 3, 4, 4));

        /* using Array Adapter

        final ArrayAdapter<Hotel> adapter = new HotelAdapter(this, 0, obj);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hotel property = obj.get(i);
                Toast.makeText(MainActivity.this, "Price : "+property.getPrice(), Toast.LENGTH_SHORT).show();
            }
        });*/

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this, obj);
        listview.setAdapter(customBaseAdapter);
    }

}
