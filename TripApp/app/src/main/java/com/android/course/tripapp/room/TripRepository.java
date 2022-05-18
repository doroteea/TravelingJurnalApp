package com.android.course.tripapp.room;



import android.app.Application;

import androidx.lifecycle.LiveData;

import com.android.course.tripapp.recycler_view.Trip;

import java.util.List;

public class TripRepository {
    private TripDao tripDao;
    private LiveData<List<Trip>> trips;

    TripRepository(Application application) {
        TripRoomDatabase tripRoomDatabase = TripRoomDatabase.getDatabase(application);
        tripDao = tripRoomDatabase.tripDao();
        trips = tripDao.getAllTrips();
    }

    public LiveData<List<Trip>> getTrips() {
        return trips;
    }

    // we must call this method on a different thread
    // it is a long running operations that should be done on a thread different than the UI (main) thread
    void insert(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }
    void updateTrip(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.updateTrip(trip);
        });
    }
}
