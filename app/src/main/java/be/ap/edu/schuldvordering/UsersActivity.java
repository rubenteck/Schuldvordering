package be.ap.edu.schuldvordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private AppDatabase database;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        database = AppDatabase.getDatabase(getApplicationContext());
        final List<User> users = database.userDao().getAllUser();

        //default users for testing
        if (users.size() == 0) {
            database.userDao().addUser(new User(1, Departement.AB.toString(), "test", "teststraat 1", "1111, test", Activiteit.Andere.toString(), Land.Aruba.toString(), "test", "11/11/11", "12/11/11", Campus.Meistraat.toString()));
            database.userDao().addUser(new User(2, Departement.AB.toString(), "test", "teststraat 1", "1111, test", Activiteit.Andere.toString(), Land.Aruba.toString(), "test", "11/11/11", "12/11/11", Campus.Meistraat.toString()));
        }

        UserArrayAdapter adapter = new UserArrayAdapter(this, (ArrayList)users );
        ListView listView = (ListView) findViewById(R.id.lstUsers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter, View v, int position, long a){
                User item = users.get(position);

                Intent intent = new Intent(UsersActivity.this,FragmentsHolder.class);
                intent.putExtra("USER_ID", item.personeelsNr);
                startActivity(intent);
            }
        });

        final Button btnList = findViewById(R.id.btnAddUser);
        btnList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(UsersActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
