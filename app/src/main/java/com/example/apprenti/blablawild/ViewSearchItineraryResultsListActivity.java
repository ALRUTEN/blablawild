package com.example.apprenti.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    ListView mListViewResults ;
    TripResultAdapter mResultsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");


        SearchRequestModel searchRequestModel= getIntent().getExtras().getParcelable("searchRequestModel");

        String departure = searchRequestModel.getVilledepart();
        String destination = searchRequestModel.getVilledestination();
        Date date = searchRequestModel.getDatedepart();
        Toast.makeText(ViewSearchItineraryResultsListActivity.this, sdf.format(date), Toast.LENGTH_SHORT).show();
        //String departure = getIntent().getStringExtra("departure");
        //String destination = getIntent().getStringExtra("destination");

        setTitle(departure + " - " +destination);


        mListViewResults = (ListView) findViewById(R.id.Road);
        ArrayList<TripResultModel> results = new ArrayList<>();


        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultsAdapter = new TripResultAdapter(this, results);

        mListViewResults.setAdapter(mResultsAdapter);

        // [...]


    }
}
