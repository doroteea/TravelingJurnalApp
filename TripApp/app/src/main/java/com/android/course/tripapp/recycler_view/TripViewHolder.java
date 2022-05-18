package com.android.course.tripapp.recycler_view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.course.tripapp.R;
import com.android.course.tripapp.room.TripDao;
import com.android.course.tripapp.room.TripRoomDatabase;

public class TripViewHolder extends RecyclerView.ViewHolder {
    private final TextView textViewName, textViewDestination;
    private final ImageButton buttonFavorite;
    private final ImageView tripPicture;
    private boolean isFavorite;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.trip_name);
        textViewDestination = itemView.findViewById(R.id.trip_destination);
        buttonFavorite = itemView.findViewById(R.id.button_favorite);
        tripPicture = itemView.findViewById(R.id.trip_picture);
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public TextView getTextViewDestination() {
        return textViewDestination;
    }

    public ImageButton getButtonFavorite() {
        return buttonFavorite;
    }

    public ImageView getTripPicture() {
        return tripPicture;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
