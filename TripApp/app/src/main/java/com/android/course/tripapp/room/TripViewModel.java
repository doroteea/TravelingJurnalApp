package com.android.course.tripapp.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android.course.tripapp.recycler_view.Trip;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository repository;

    private final LiveData<List<Trip>> trips;

    public TripViewModel(@NonNull Application application) {
        super(application);
        repository = new TripRepository(application);
        trips = repository.getTrips();
    }

    public LiveData<List<Trip>> getTrips() {

        return trips;
    }

    public void insert(Trip trip) {
        repository.insert(trip);
    }

    public void updateTrip(Trip trip) {
        repository.updateTrip(trip);
    }
}