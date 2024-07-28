package com.example.uas_mpcoba1.Adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.uas_mpcoba1.DetailActivity;
import com.example.uas_mpcoba1.Domain.Film;
import com.example.uas_mpcoba1.MainActivity;
import com.example.uas_mpcoba1.R;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    ArrayList<Film> items;
    Context context;

    public FilmAdapter(ArrayList<Film> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_film, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film film = items.get(position);
        holder.titleTxt.setText(film.getTitle());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(20));

        Glide.with(context)
                .load(film.getPoster())
                .apply(requestOptions)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("FILM_DETAILS", film);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleText);
            pic = itemView.findViewById(R.id.film_pic);
        }
    }
}
