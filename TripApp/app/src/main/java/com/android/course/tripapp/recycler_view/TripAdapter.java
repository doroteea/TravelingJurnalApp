package com.android.course.tripapp.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.course.tripapp.R;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {
    private List<Trip> trips;

    public TripAdapter(List<Trip> trips) {
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item, parent, false);
        return new TripViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip currentTrip = trips.get(position);
        holder.getTripPicture().setImageResource(R.drawable.plane);
        holder.getTextViewName().setText(currentTrip.getName());
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        if (currentTrip.isFavorite()) {
            holder.getButtonFavorite().setImageResource(R.drawable.ic_baseline_star_24);
        }

        holder.setFavorite(currentTrip.isFavorite());
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
