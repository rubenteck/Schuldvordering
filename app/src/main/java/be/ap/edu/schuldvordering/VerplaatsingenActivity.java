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

public class VerplaatsingenActivity extends Fragment {

    private AppDatabase database;
    private ListView lv;
    private int userId;

    public VerplaatsingenActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_verplaatsingen, container, false);

        Intent intent = getActivity().getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        database = AppDatabase.getDatabase(getActivity().getApplicationContext());
        final List<Verplaatsingen> verplaatsingen = database.verplaatsingenDao().findVerplaatsingenForUser(userId);

        //default users for testing
        if (verplaatsingen.size() == 0) {
            database.verplaatsingenDao().addVerplaatsingen(new Verplaatsingen(userId, "11/11/11", "adresvertrek", "adresbestemming", "code", "5", "lokale munt", "60"));
            database.verplaatsingenDao().addVerplaatsingen(new Verplaatsingen(userId, "12/11/11", "adresvertrek", "adresbestemming", "code", "5", "lokale munt", "60"));
        }

        VerplaatsingenArrayAdapter adapter = new VerplaatsingenArrayAdapter(getActivity(), (ArrayList)verplaatsingen );
        ListView listView = (ListView) rootView.findViewById(R.id.lstVerplaatsingen);
        listView.setAdapter(adapter);

        final Button btnList = rootView.findViewById(R.id.btnAddVerplaatsing);
        btnList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddVerplaatsingActivity.class);
                intent.putExtra("USER_ID", userId);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
