package com.example.uas_mpcoba1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_mpcoba1.Adapter.FilmAdapter;
import com.example.uas_mpcoba1.Domain.Film;
import com.example.uas_mpcoba1.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private FirebaseDatabase database;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = ((LinearLayoutManager) binding.view0.getLayoutManager()).findFirstVisibleItemPosition();
            binding.view0.smoothScrollToPosition(currentItem + 1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton btnLocation = binding.btnLocation;
        btnLocation.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CinemaMapsActivity.class);
            startActivity(intent);
        });

        database = FirebaseDatabase.getInstance();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        initNowPlaying();
        initNewMovies();
        initUpcoming();


    }

    private void initNowPlaying() {
        DatabaseReference myRef = database.getReference("Items");
        binding.loading0.setVisibility(View.VISIBLE);
        ArrayList<Film> items = new ArrayList<>();

        RecyclerView view0 = binding.view0;
        view0.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        });
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        items.add(issue.getValue(Film.class));
                    }
                    if (!items.isEmpty()) {
                        binding.view0.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.HORIZONTAL, false));
                        binding.view0.setAdapter(new FilmAdapter(items));
                    }
                    binding.loading0.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initNewMovies() {
        DatabaseReference myRef = database.getReference("Items");
        binding.loading1.setVisibility(View.VISIBLE);
        ArrayList<Film> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        items.add(issue.getValue(Film.class));
                    }
                    if (!items.isEmpty()) {
                        binding.view1.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.HORIZONTAL, false));
                        binding.view1.setAdapter(new FilmAdapter(items));
                    }
                    binding.loading1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initUpcoming() {
        DatabaseReference myRef = database.getReference("Items");
        binding.loading2.setVisibility(View.VISIBLE);
        ArrayList<Film> items = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        items.add(issue.getValue(Film.class));
                    }
                    if (!items.isEmpty()) {
                        binding.view2.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.HORIZONTAL, false));
                        binding.view2.setAdapter(new FilmAdapter(items));
                    }
                    binding.loading2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
