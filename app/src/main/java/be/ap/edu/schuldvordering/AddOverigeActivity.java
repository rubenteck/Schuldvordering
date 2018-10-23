package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOverigeActivity extends AppCompatActivity {

    private Overige overige;
    private AppDatabase database;
    private Integer userId;
    private String datum;
    private String omschrijving;
    private String bedrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_overige);

        //get textfields
        final EditText txtDatum = (EditText) findViewById(R.id.txtDatum);
        final EditText txtOmschrijving = (EditText) findViewById(R.id.txtOmschrijving);
        final EditText txtBedrag = (EditText) findViewById(R.id.txtBedrag);

        //db connection
        database = AppDatabase.getDatabase(getApplicationContext());
        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        final Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datum = txtDatum.getText().toString();
                omschrijving = txtOmschrijving.getText().toString();
                bedrag = txtBedrag.getText().toString();

                overige = new Overige(userId, datum, omschrijving, bedrag);
                database.overigeDao().addOverige(overige);

            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
