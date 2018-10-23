package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddVerplaatsingActivity extends AppCompatActivity {

    private Verplaatsingen verplaatsing;
    private AppDatabase database;
    private Integer userId;
    private String datum;
    private String adresVertrek;
    private String adresBestemming;
    private String code;
    private String km;
    private String bedragLokaleMunt;
    private String bedrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_verplaatsing);

        //get textfields
        final EditText txtDatum = (EditText) findViewById(R.id.txtDatum);
        final EditText txtAdresVertrek = (EditText) findViewById(R.id.txtAdresVertrek);
        final EditText txtAdresBestemming = (EditText) findViewById(R.id.txtAdresBestemming);
        final EditText txtCode = (EditText) findViewById(R.id.txtCode);
        final EditText txtKm = (EditText) findViewById(R.id.txtKm);
        final EditText txtBedragLokaleMunt = (EditText) findViewById(R.id.txtBedragLokaleMunt);
        final EditText txtBedrag = (EditText) findViewById(R.id.txtBedrag);

        //db connection
        database = AppDatabase.getDatabase(getApplicationContext());
        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        final Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datum = txtDatum.getText().toString();
                adresVertrek = txtAdresVertrek.getText().toString();
                adresBestemming = txtAdresBestemming.getText().toString();
                code = txtCode.getText().toString();
                km = txtKm.getText().toString();
                bedragLokaleMunt = txtBedragLokaleMunt.getText().toString();
                bedrag = txtBedrag.getText().toString();

                verplaatsing = new Verplaatsingen(userId, datum, adresVertrek, adresBestemming, code, km, bedragLokaleMunt, bedrag);
                database.verplaatsingenDao().addVerplaatsingen(verplaatsing);

            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
