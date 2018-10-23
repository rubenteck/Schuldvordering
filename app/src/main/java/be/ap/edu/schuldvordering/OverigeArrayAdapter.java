package be.ap.edu.schuldvordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OverigeArrayAdapter extends ArrayAdapter<Overige> {

    public OverigeArrayAdapter(Context context, ArrayList<Overige> overigen) {
        super(context, 0, overigen);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Overige overige = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_overige, parent, false);
        }
        // Lookup view for data population
        TextView tvOverige = (TextView) convertView.findViewById(R.id.tvOverige);
        // Populate the data into the template view using the data object
        tvOverige.setText(overige.datum + ", €" + overige.bedrag + ", " + overige.omschrijving);
        // Return the completed view to render on screen
        return convertView;
    }

}