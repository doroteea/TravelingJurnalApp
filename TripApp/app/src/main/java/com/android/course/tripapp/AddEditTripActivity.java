package com.android.course.tripapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.android.course.tripapp.util.DatePickerFragment;


public class AddEditTripActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {

    private EditText tripEditText;
    private EditText destinationEditText;
    private RadioGroup radioGroupTripType;
    private RadioButton radioButtonTripType;
    private TextView textViewPrice;
    private SeekBar seekBar;
    private Button buttonStartDate;
    private Button buttonEndDate;
    private RatingBar ratingBar;
    private Button buttonSave;

    private String startDate;
    private String endDate;

    private Boolean dateChosen=false;
    private Boolean chose=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_trip);
    }

    protected void initViews() {
        tripEditText = findViewById(R.id.tripEditText);
        destinationEditText = findViewById(R.id.destinationEditText);
        radioGroupTripType = findViewById(R.id.radioGroupTripType);
        textViewPrice = findViewById(R.id.textViewPrice);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewPrice.setText("Trip price is" + String.valueOf(i * 10) + "€");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonStartDate = findViewById(R.id.buttonStartDate);
        startDate = getString(R.string.start_date);
        buttonStartDate.setOnClickListener(v -> {
            dateChosen = false;
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "view");
        });
        buttonEndDate = findViewById(R.id.buttonEndDate);
        endDate = getString(R.string.end_date);
        buttonEndDate.setOnClickListener(v -> {
            dateChosen = true;
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "view");
        });
        ratingBar = findViewById(R.id.ratingBar);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            chose = true;
            tripEditText.setText(bundle.getString("trip"));
            destinationEditText.setText(bundle.getString("destination"));
            if(bundle.getString("tripType").equals(R.string.city_break)) {
                radioGroupTripType.check(R.id.radio0);
            }
            else if(bundle.getString("tripType").equals(R.string.seaside)) {
                radioGroupTripType.check(R.id.radio1);
            }
            else if(bundle.getString("tripType").equals(R.string.mountains)) {
                radioGroupTripType.check(R.id.radio2);
            }
            seekBar.setProgress(Integer.parseInt(bundle.getString("price")));
            textViewPrice.setText("Trip price is" + String.valueOf(seekBar.getProgress() * 10) + "€");

            startDate = bundle.getString("startDate");
            buttonStartDate.setHint("start date");

            endDate = bundle.getString("endDate");
            buttonEndDate.setHint("end date");

            ratingBar.setRating(Float.parseFloat(bundle.getString("rating")));

        }
        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            if(TextUtils.isEmpty(tripEditText.getText())) {
                tripEditText.setError(getString(R.string.trip_error));
            }
            else if(TextUtils.isEmpty(destinationEditText.getText())) {
                destinationEditText.setError(getString(R.string.destination_error));
            }
            else if (startDate.contains(" ") || endDate.contains(" ")) {
                Toast.makeText(this, getString(R.string.select_date), Toast.LENGTH_SHORT).show();
            }
            else if (startDate.contains("DD") || endDate.contains("DD")) {
                Toast.makeText(this, getString(R.string.select_date), Toast.LENGTH_SHORT).show();
            }else {
                if (chose) {
                    intent.putExtra("chose", R.string.chose_string);
                }
                intent.putExtra("trip", tripEditText.getText().toString());
                intent.putExtra("destination", destinationEditText.getText().toString());
                radioButtonTripType = findViewById(radioGroupTripType.getCheckedRadioButtonId());
                intent.putExtra("tripType", radioButtonTripType.getText().toString());
                intent.putExtra("price", String.valueOf(seekBar.getProgress() * 10));
                intent.putExtra("startDate", startDate);
                intent.putExtra("endDate", endDate);
                intent.putExtra("rating", String.valueOf(ratingBar.getRating()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if(!dateChosen){
            month++;
            startDate = dayOfMonth + " " + month + " " + year;
            buttonStartDate.setHint(startDate);
        }
        else{
            month++;
            endDate = dayOfMonth + " " + month + " " + year;
            buttonEndDate.setHint(endDate);
        }
    }

    }
