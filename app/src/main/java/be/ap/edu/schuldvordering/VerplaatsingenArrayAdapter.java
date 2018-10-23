package be.ap.edu.schuldvordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VerplaatsingenArrayAdapter extends ArrayAdapter<Verplaatsingen> {

    public VerplaatsingenArrayAdapter(Context context, ArrayList<Verplaatsingen> verplaatsingen) {
        super(context, 0, verplaatsingen);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Verplaatsingen verplaatsing = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_verplaatsingen, parent, false);
        }
        // Lookup view for data population
        TextView tvVerplaatsing = (TextView) convertView.findViewById(R.id.tvVerplaatsing);
        TextView tvAfstand = (TextView) convertView.findViewById(R.id.tvAfstand);
        // Populate the data into the template view using the data object
        tvVerplaatsing.setText("id: " + verplaatsing.id + ", " + verplaatsing.datum + ", " + verplaatsing.adresVertrek + " tot " + verplaatsing.adresBestemming);
        tvVerplaatsing.setText("code: " + verplaatsing.code + ", " + verplaatsing.km + " km, " + verplaatsing.bedragLokaleMunt + ", €" + verplaatsing.bedrag);
        // Return the completed view to render on screen
        return convertView;
    }

}