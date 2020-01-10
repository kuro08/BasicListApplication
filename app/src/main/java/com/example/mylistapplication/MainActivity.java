package com.example.mylistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    private ArrayList<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Daftar Pulau Terbesar Di Indonesia");
        }

        rvItems = findViewById(R.id.rv_item);
        rvItems.setHasFixedSize(true);

        list.addAll(ListItem.getListData());
        showRecyclerList();
    }
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent moveIntentAbout = new Intent (MainActivity.this, AboutPage.class);
            startActivity(moveIntentAbout);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        ListItemAdapter listItemAdapter = new ListItemAdapter(list);
        rvItems.setAdapter(listItemAdapter);

        listItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Item data) {
                Intent moveIntent = new Intent (MainActivity.this, DetailPage.class);
                moveIntent.putExtra("NAMA",data.getNama());
                moveIntent.putExtra("DESKRIPSI",data.getDesc());
                moveIntent.putExtra("GAMBAR",data.getPhoto());
                moveIntent.putExtra("KOORDINAT",data.getCoordinates());
                moveIntent.putExtra("POPULASI",data.getPopulation());
                moveIntent.putExtra("KOTA TERBESAR",data.getCity());
                startActivity(moveIntent);
            }
        });
    }
}