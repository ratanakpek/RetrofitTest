package com.example.ratanakpek.gridview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gv = (GridView) findViewById(R.id.gridview);
        Button btnlist = (Button) findViewById(R.id.listview);
        Button btngrid = (Button) findViewById(R.id.grid);
        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gv.setNumColumns(GridView.AUTO_FIT);
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              gv.setNumColumns(GridView.STRETCH_COLUMN_WIDTH);

            }
        });

        ImageAdapter adapter = new ImageAdapter(this);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent go = new Intent(getApplication(), SingleImageVIew.class);
                go.putExtra("id", i);
                startActivity(go);

            }
        });
    }
}
