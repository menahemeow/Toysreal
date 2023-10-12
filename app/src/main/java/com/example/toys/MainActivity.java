package com.example.toys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.model.Toy;
import com.example.model.Toys;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvToys;
    private ToysAdapter adapter;
    private Toys toys;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeViews();
        makeToys();

        setRecyclerView();
    }

    private void makeToys() {
        toys = new Toys();
        toys.add(new Toy("kaki", 69 ));
        toys.add(new Toy("eved", 420 ));
        toys.add(new Toy("wiwi", 54 ));
        toys.add(new Toy("omer", 0.99 ));
        toys.add(new Toy("isha", 120 ));
        toys.add(new Toy("yeled", 75 ));

    }

    private void initializeViews() {
        rvToys = findViewById(R.id.rvToys);
    }

    private void setRecyclerView() {
        ToysAdapter.OnItemClickListener listener = new ToysAdapter.OnItemClickListener() {

            @Override
            public void onItemClicked(Toy toy) {

            }

            @Override
            public void onItemClicked() {

// To Do

            }
        };
        ToysAdapter.OnItemLongClickListener longListener = new ToysAdapter.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClicked(Toy toy) {
                return false;
            }

            @Override
            public boolean onItemLongClicked() {
// To Do
                return true;
            }
        };
        adapter = new ToysAdapter(this, toys, R.layout.single_toy_layout);
        rvToys.setAdapter(adapter);
        rvToys.setLayoutManager(new LinearLayoutManager(this));
    }
}