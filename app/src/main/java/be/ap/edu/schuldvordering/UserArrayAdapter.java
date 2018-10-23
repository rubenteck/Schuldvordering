package be.ap.edu.schuldvordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserArrayAdapter extends ArrayAdapter<User> {

    public UserArrayAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
        // Lookup view for data population
        TextView tvUser = (TextView) convertView.findViewById(R.id.tvUser);
        TextView tvActiviteit = (TextView) convertView.findViewById(R.id.tvActiviteit);
        // Populate the data into the template view using the data object
        tvUser.setText("id: " + String.valueOf(user.personeelsNr) + ", " + user.departement + ", " + user.naam + ", " + user.campus);
        tvActiviteit.setText(user.activiteit + ", " + user.land + ", " + user.vertrekDatum + " - " + user.retourDatum);
        // Return the completed view to render on screen
        return convertView;
    }

}