package com.example.apprenti.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by apprenti on 15/09/17.
 */

public class TripResultAdapter  extends BaseAdapter {
    private Context context; //context
    private ArrayList<TripResultModel> items; //data source of the list adapter

    //public constructor
    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_layout, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description

        TextView textViewfirstname = (TextView) convertView.findViewById(R.id.textFirstName);
        TextView textViewDepartureTime = (TextView) convertView.findViewById(R.id.textDepartureName);
        TextView textViewViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        textViewfirstname.setText(currentItem.getFirstName());
        textViewDepartureTime.setText(sdf.format(currentItem.getDepartureTime()));
        textViewViewPrice.setText(String.valueOf(currentItem.getViewPrice()) +" € ");


        // returns the view for the current row
        return convertView;
    }
}
