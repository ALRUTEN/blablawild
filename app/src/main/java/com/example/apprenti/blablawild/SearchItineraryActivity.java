package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    Button button;
    EditText departure;
    EditText destination;
    EditText date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);


        button = (Button) findViewById(R.id.button);
        departure = (EditText) findViewById(R.id.Departure);
        destination = (EditText) findViewById(R.id.Destination);
        date = (EditText) findViewById(R.id.editDate);
        date.setFocusable(false);


        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener calendar = new DatePickerDialog.OnDateSetListener() {
            private void updateLabel() {
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                date.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };


        date.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        // TODO Auto-generated method stub
                                        new DatePickerDialog(SearchItineraryActivity.this, calendar, myCalendar
                                                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                                    }
                                });


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String departureText = departure.getText().toString();
                        String destinationText = destination.getText().toString();

                        if ((departureText.equals("")) || (destinationText.equals(""))) {
                            Toast.makeText(SearchItineraryActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();

                        } else {
                            Intent intent = new Intent(SearchItineraryActivity.this,
                                    ViewSearchItineraryResultsListActivity.class);
                            intent.putExtra("departure", departure.getText().toString());
                            intent.putExtra("destination", destination.getText().toString());
                            startActivity(intent);

                        }
                    }
                });



}



}
