package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddHotelActivity extends AppCompatActivity {

    private Hotel hotel;
    private AppDatabase database;
    private Integer userId;
    private String periode;
    private String bedragLokaleMunt;
    private String bedrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);

        //get textfields
        final EditText txtPeriode = (EditText) findViewById(R.id.txtPeriode);
        final EditText txtBedragLokaleMunt = (EditText) findViewById(R.id.txtBedragLokaleMunt);
        final EditText txtBedrag = (EditText) findViewById(R.id.txtBedrag);

        //db connection
        database = AppDatabase.getDatabase(getApplicationContext());
        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", 0);

        final Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                periode = txtPeriode.getText().toString();
                bedragLokaleMunt = txtBedragLokaleMunt.getText().toString();
                bedrag = txtBedrag.getText().toString();

                hotel = new Hotel(userId, periode, bedragLokaleMunt, bedrag);
                database.hotelDao().addHotel(hotel);

            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
