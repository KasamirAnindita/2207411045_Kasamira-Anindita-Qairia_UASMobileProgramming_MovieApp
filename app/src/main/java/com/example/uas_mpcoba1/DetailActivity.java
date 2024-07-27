package com.example.uas_mpcoba1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

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

        setVariable();

    }

    private void setVariable(){
        Film item = (Film) getIntent().getSerializableExtra("object");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(), new GranularRoundedCorners(0, 0, 50, 50));

        Glide.with(this)
                .load(item.getPoster())
                .apply(requestOptions)
                .into(binding.posterNormalImg);
        Glide.with(this)
                .load(item.getPoster())
                .apply(requestOptions)
                .into(binding.posterBigImg);

                binding.movieTitle.setText((item.getTitle()));
                binding.movieRate.setText(("Rating" + item.getImdb()));
                binding.movieDuration.setText(item.getTime());
                binding.dateMovie.setText(item.getYear());
                binding.moviesSummary.setText(item.getDescription());
                binding.posterNormalImg.setOnClickListener(v -> finish());

//                float radius = 10f;
//                View decorView = getWindow().getDecorView();
//        ViewGroup rootView = (ViewGroup)  decorView.findViewById()
    }
}
