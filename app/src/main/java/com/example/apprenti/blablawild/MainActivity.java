package com.example.apprenti.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.example.apprenti.blablawild.R.id.Departure;
import static com.example.apprenti.blablawild.R.id.Destination;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ajouter un Intent ici
                Intent intent = new Intent(MainActivity.this,
                        SearchItineraryActivity.class);
       //         intent.putExtra("departure", Departure.);
       //         intent.putExtra(“destination”, Destination);
                startActivity(intent);
            }
        });
    }

}
