package com.example.advancecourse.homework;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.paginate.Paginate;
import java.util.ArrayList;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by advancecourse on 11/11/16.
 */

public class DashBoard extends Activity implements Communicator, DialoadYesNo {
    RecyclerView recycler;
    ArrayList<Products> product = new ArrayList<>();
    MyRecyclers adapter;
    int i;
    int page = 1;
    int productItem = 20;
    int moredata = 20;
    boolean loading;
    //set the id of dialog
    int deleteid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //Recyclers properties
        recycler = (RecyclerView) findViewById(R.id.myrecycler);
        generateProduct(1, productItem);
        recycler.setHasFixedSize(true);
        //Create Layout for ReoyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(mLayoutManager);

        adapter = new MyRecyclers(product, this);

        //Create Animation
        ScaleInAnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(adapter);
        alphaAdapter.setFirstOnly(true);

        //Set the adater with animation
        recycler.setAdapter(alphaAdapter);

        Paginate.Callbacks callbacks = new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                loading = true;
                page++;
                productItem += moredata;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        while (i <= productItem) {
                            generateProduct(i, productItem);
                            adapter.notifyItemInserted(product.size() - 1);
                            i++;
                        }
                        loading = false;
                    }
                }, 2000);

            }

            @Override
            public boolean isLoading() {
                return loading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return page == 5;
            }
        };

        Paginate.with(recycler, callbacks)
                .setLoadingTriggerThreshold(5)
                .addLoadingListItem(true)
                .build();

    }


    //Auto gengerate the product
    public void generateProduct(int start, int stop) {
        for (i = start; i <= stop; i++) {
            product.add(new Products("Samsung Galaxy S " + i, "12", "2/3/12", "This is a " +
                    "new type from korea, so you can contact use today. " + i, "test"));

        }
    }


    //create popupmenu and dialog menu
    @Override
    public void onMenuImageClick(final int index, View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater menu = popupMenu.getMenuInflater();
        menu.inflate(R.menu.men, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mDelete:
                        DialogFragment d = new DialogOverFlow();
                        d.show(getFragmentManager(), "Dialog");
                        deleteid = index;
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "No Action ", Toast.LENGTH_SHORT).show();
                        return false;
                }
            }
        });
        popupMenu.show();

    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Item" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            if (requestCode == 2) {
                String title = data.getStringExtra("Title");
                String description = data.getStringExtra("Descrip");
                String views = data.getStringExtra("Views");
                if (resultCode != RESULT_CANCELED) {
                    product.add(0, new Products(title, views, "2/3/34", description, ""));
                    adapter.notifyItemInserted(0);

                    SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("title", title);
                    editor.putString("description", description);
                    editor.putString("views", views);
                    editor.commit();
                }
            }
        }else{
            Log.d("data", "null");
        }
    }

    //Navigate to AddProdut and bring the result back to the method onActivityResult
    public void addProduct(View v) {

    }


    //From interface to handle YES
    @Override
    public void onYesClick() {
        Toast.makeText(this, "Yes" + deleteid, Toast.LENGTH_SHORT).show();
        product.remove(deleteid);
        adapter.notifyItemRemoved(deleteid);
    }

    //From interface to handle NO
    @Override
    public void onNoClick() {
        Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menucus = new MenuInflater(this);
        menucus.inflate(R.menu.men, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mDelete:
                Intent addProduct = new Intent(this, AddProduct.class);
                startActivityForResult(addProduct, 2);
                break;
            default:
                Toast.makeText(this, "No handle click", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
