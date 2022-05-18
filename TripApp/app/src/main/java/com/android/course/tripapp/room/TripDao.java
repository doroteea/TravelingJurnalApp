package com.android.course.tripapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.android.course.tripapp.recycler_view.Trip;

import java.util.List;

@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Trip trip);

    @Query("SELECT * from trips_table")
    LiveData<List<Trip>> getAllTrips();

    @Update
    void updateTrip(Trip trip);

}
