package be.ap.edu.schuldvordering;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VerblijfArrayAdapter extends ArrayAdapter<Verblijf> {

    public VerblijfArrayAdapter(Context context, ArrayList<Verblijf> verblijven) {
        super(context, 0, verblijven);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Verblijf verblijf = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_verblijf, parent, false);
        }
        // Lookup view for data population
        TextView tvVerblijf = (TextView) convertView.findViewById(R.id.tvVerblijf);
        // Populate the data into the template view using the data object
        String ontbijt, lunch, avondmaal;
        if (verblijf.ontbijt)
            ontbijt = "ontbijt zelf betaald";
        else
            ontbijt = "ontbijt door AP betaald";

        if(verblijf.lunch)
            lunch = "lunch zelf betaald";
        else
            lunch = "lunch door AP betaald";

        if(verblijf.avondmaal)
            avondmaal = "avondmaal zelf betaald";
        else
            avondmaal = "avondmaal door AP betaald";

        tvVerblijf.setText(verblijf.datumVerblijfsDag + ", " + ontbijt + ", " + lunch + ", " + avondmaal + ", €" + verblijf.bedrag);
        // Return the completed view to render on screen
        return convertView;
    }

}