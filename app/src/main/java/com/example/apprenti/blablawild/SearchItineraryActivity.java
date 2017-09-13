package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    Button button;
    EditText departure;
    EditText destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);



        button = (Button) findViewById(R.id.button);
        departure = (EditText) findViewById(R.id.Departure);
        destination = (EditText) findViewById(R.id.Destination);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String departureText = departure.getText().toString();
                String destinationText = destination.getText().toString();

                if ((departureText.equals("")) || (destinationText.equals(""))) {
                    Toast.makeText(SearchItineraryActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();

                }else{
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
