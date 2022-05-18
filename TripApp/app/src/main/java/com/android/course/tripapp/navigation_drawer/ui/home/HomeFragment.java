package com.android.course.tripapp.navigation_drawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.course.tripapp.R;
import com.android.course.tripapp.recycler_view.Trip;
import com.android.course.tripapp.recycler_view.TripAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewTrip;
    private List<Trip> trips;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTrip = view.findViewById(R.id.recyclerViewTrip);
        setDataSource();
        setLayoutManager();
        recyclerViewTrip.setAdapter(getTripAdapter());
        return view;
    }

    private TripAdapter getTripAdapter() {
        return new TripAdapter(trips);
    }

    private void setLayoutManager() {
        recyclerViewTrip.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setDataSource() {
        trips = new ArrayList<>();
        Trip trip = new Trip("Paris Trip", "Paris", "seaside", 550, "12.12.2022", "13.12.2022", 3.5, true);
        trips.add(trip);
    }
}
