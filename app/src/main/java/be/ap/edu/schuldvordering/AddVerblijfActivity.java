package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddVerblijfActivity extends AppCompatActivity {

    private Verblijf verblijf;
    private AppDatabase database;
    private Integer userId;
    private String datumVerblijfsDag;
    private Boolean ontbijt;
    private Boolean lunch;
    private Boolean avondmaal;
    private Boolean kleineUitgaven;
    private String bedrag;

    Boolean[] bool = {true, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_verblijf);

        //fill spinners
        final Spinner spnOntbijt = (Spinner) findViewById(R.id.spnOntbijt);
        spnOntbijt.setAdapter(new ArrayAdapter<Boolean>(this, android.R.layout.simple_spinner_item, bool));
        final Spinner spnLunch = (Spinner) findViewById(R.id.spnLunch);
        spnLunch.setAdapter(new ArrayAdapter<Boolean>(this, android.R.layout.simple_spinner_item, bool));
        final Spinner spnAvondmaal = (Spinner) findViewById(R.id.spnAvondmaal);
        spnAvondmaal.setAdapter(new ArrayAdapter<Boolean>(this, android.R.layout.simple_spinner_item, bool));
        final Spinner spnKleineUitgaven = (Spinner) findViewById(R.id.spnKleineUitgaven);
        spnKleineUitgaven.setAdapter(new ArrayAdapter<Boolean>(this, android.R.layout.simple_spinner_item, bool));

        //get textfields
        final EditText txtDatumVerblijfsDag = (EditText) findViewById(R.id.txtDatumVerblijfsDag);
        final EditText txtBedrag = (EditText) findViewById(R.id.txtBedrag);

        //db connection
        database = AppDatabase.getDatabase(getApplicationContext());
        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        final Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ontbijt = (boolean)spnOntbijt.getSelectedItem();
                lunch = (boolean)spnLunch.getSelectedItem();
                avondmaal = (boolean)spnAvondmaal.getSelectedItem();
                kleineUitgaven = (boolean)spnKleineUitgaven.getSelectedItem();

                datumVerblijfsDag = txtDatumVerblijfsDag.getText().toString();
                bedrag = txtBedrag.getText().toString();

                verblijf = new Verblijf(userId, datumVerblijfsDag, ontbijt, lunch, avondmaal, kleineUitgaven, bedrag);
                database.verblijfDao().addVerblijf(verblijf);

            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
