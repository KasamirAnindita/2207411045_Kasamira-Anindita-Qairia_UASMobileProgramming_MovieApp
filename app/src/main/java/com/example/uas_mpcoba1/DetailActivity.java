package com.example.uas_mpcoba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.uas_mpcoba1.Domain.Film;
import com.example.uas_mpcoba1.databinding.ActivityDetailBinding;


public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView btnBackDetail = binding.btnBackDetail;
        btnBackDetail.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
        });


        Film item = (Film) getIntent().getSerializableExtra("FILM_DETAILS"); // Use the constant key
        if (item != null) {
            setVariable(item);
        } else {

        }
    }

    private void setVariable(Film item) {
        // Set variables for the film details as before
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop());

        Glide.with(this)
                .load(item.getPoster())
                .apply(requestOptions)
                .into(binding.posterNormalImg);
        Glide.with(this)
                .load(item.getPoster())
                .apply(requestOptions)
                .into(binding.posterBigImg);

        binding.movieTitle.setText(item.getTitle());
        binding.movieRate.setText("Rating: " + item.getImdb());
        binding.movieDuration.setText(item.getTime());
        binding.dateMovie.setText(String.valueOf(item.getYear()));
        binding.moviesSummary.setText(item.getDescription());
        binding.posterNormalImg.setOnClickListener(v -> finish());
    }
}

