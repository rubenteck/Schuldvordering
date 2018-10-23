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

public class VerblijvenActivity extends Fragment {

    private AppDatabase database;
    private ListView lv;
    private int userId;

    public VerblijvenActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_verblijven, container, false);

        Intent intent = getActivity().getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        database = AppDatabase.getDatabase(getActivity().getApplicationContext());
        final List<Verblijf> verblijven = database.verblijfDao().findVerblijfForUser(userId);

        //default users for testing
        if (verblijven.size() == 0) {
            database.verblijfDao().addVerblijf(new Verblijf(userId, "11/11/11", true, true, true, true, "60"));
            database.verblijfDao().addVerblijf(new Verblijf(userId, "12/11/11", true, true, true, true, "60"));
        }

        VerblijfArrayAdapter adapter = new VerblijfArrayAdapter(getActivity(), (ArrayList)verblijven );
        ListView listView = (ListView) rootView.findViewById(R.id.lstVerblijven);
        listView.setAdapter(adapter);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long a){
                Verblijf item = verblijven.get(position);

                //Intent intent = new Intent(UsersActivity.this,MenuActivity.class);
                //intent.putExtra("USER_ID", item.personeelsNr);
                //startActivity(intent);
            }
        });
        */

        final Button btnList = rootView.findViewById(R.id.btnAddVerblijf);
        btnList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddVerblijfActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
