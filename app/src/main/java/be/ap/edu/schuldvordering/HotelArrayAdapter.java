package be.ap.edu.schuldvordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelArrayAdapter extends ArrayAdapter<Hotel> {

    public HotelArrayAdapter(Context context, ArrayList<Hotel> hotels) {
        super(context, 0, hotels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Hotel hotel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_hotel, parent, false);
        }
        // Lookup view for data population
        TextView tvHotel = (TextView) convertView.findViewById(R.id.tvHotel);
        // Populate the data into the template view using the data object
        tvHotel.setText(hotel.periode + ", " + hotel.bedragLokaleMunt + ", €" + hotel.bedrag);
        // Return the completed view to render on screen
        return convertView;
    }

}