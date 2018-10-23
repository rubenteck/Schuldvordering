package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelsActivity extends Fragment {

    private AppDatabase database;
    private ListView lv;
    private int userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_hotels, container, false);

        Intent intent = getActivity().getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        database = AppDatabase.getDatabase(getActivity().getApplicationContext());
        final List<Hotel> hotels = database.hotelDao().findHotelForUser(userId);

        //default users for testing
        if (hotels.size() == 0) {
            database.hotelDao().addHotel(new Hotel(userId, "11/11/11-12/11/11", "lokale munt", "60"));
            database.hotelDao().addHotel(new Hotel(userId, "12/11/11-12/11/11", "lokale munt", "60"));
        }

        HotelArrayAdapter adapter = new HotelArrayAdapter(getActivity(), (ArrayList)hotels );
        ListView listView = (ListView) rootView.findViewById(R.id.lstHotels);
        listView.setAdapter(adapter);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long a){
                Hotel item = hotels.get(position);

                //Intent intent = new Intent(UsersActivity.this,MenuActivity.class);
                //intent.putExtra("USER_ID", item.personeelsNr);
                //startActivity(intent);
            }
        });
        */

        final Button btnList = rootView.findViewById(R.id.btnAddHotel);
        btnList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddHotelActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        return  rootView;
    }
}
