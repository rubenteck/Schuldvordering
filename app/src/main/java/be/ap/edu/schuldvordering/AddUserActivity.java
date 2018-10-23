package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    private User user;
    private AppDatabase database;
    private Integer userId;
    private String departement;
    private String naam;
    private String straat;
    private String gemeente;
    private String activiteit;
    private String land;
    private String stad;
    private String vertrekDatum;
    private String retourDatum;
    private String campus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        //database.userDao().removeAllUsers();

        //fill spinners
        final Spinner spnDepartement = (Spinner) findViewById(R.id.spnDepartement);
        spnDepartement.setAdapter(new ArrayAdapter<Departement>(this, android.R.layout.simple_spinner_item, Departement.values()));
        final Spinner spnActiviteit = (Spinner) findViewById(R.id.spnActiviteit);
        spnActiviteit.setAdapter(new ArrayAdapter<Activiteit>(this, android.R.layout.simple_spinner_item, Activiteit.values()));
        final Spinner spnLand = (Spinner) findViewById(R.id.spnLand);
        spnLand.setAdapter(new ArrayAdapter<Land>(this, android.R.layout.simple_spinner_item, Land.values()));
        final Spinner spnCampus = (Spinner) findViewById(R.id.spnCampus);
        spnCampus.setAdapter(new ArrayAdapter<Campus>(this, android.R.layout.simple_spinner_item, Campus.values()));

        //get textfields
        final EditText txtPersoneelsNr = (EditText) findViewById(R.id.txtPersoneelsNr);
        final EditText txtNaam = (EditText) findViewById(R.id.txtNaam);
        final EditText txtStraat = (EditText) findViewById(R.id.txtStraat);
        final EditText txtGemeente = (EditText) findViewById(R.id.txtGemeente);
        final EditText txtStad = (EditText) findViewById(R.id.txtStad);
        final EditText txtVertrekDatum = (EditText) findViewById(R.id.txtVertrekDatum);
        final EditText txtRetourDatum = (EditText) findViewById(R.id.txtRetourDatum);

        //db connection
        database = AppDatabase.getDatabase(getApplicationContext());

        final Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (txtPersoneelsNr.getText() != null) {
                    userId = Integer.parseInt(txtPersoneelsNr.getText().toString());

                    departement = spnDepartement.getSelectedItem().toString();
                    activiteit = spnActiviteit.getSelectedItem().toString();
                    land = spnLand.getSelectedItem().toString();
                    campus = spnCampus.getSelectedItem().toString();

                    naam = txtNaam.getText().toString();
                    straat = txtStraat.getText().toString();
                    gemeente = txtGemeente.getText().toString();
                    stad = txtStad.getText().toString();
                    vertrekDatum = txtVertrekDatum.getText().toString();
                    retourDatum = txtRetourDatum.getText().toString();

                    user = new User(userId, departement, naam, straat, gemeente, activiteit, land, stad, vertrekDatum, retourDatum, campus);
                    database.userDao().addUser(user);
                }

                Intent intent = new Intent(AddUserActivity.this, UsersActivity.class);
                intent.putExtra("USER_ID", userId);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
