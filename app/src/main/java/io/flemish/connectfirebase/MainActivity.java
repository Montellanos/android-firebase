package io.flemish.connectfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@SuppressWarnings({"unused"})
public class MainActivity extends AppCompatActivity {


    private FirebaseDatabase db;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db =  FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("user");

        text = (TextView) findViewById(R.id.text);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                text.setText(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Algo salio mal", databaseError.toException());

            }
        };
        myRef.addValueEventListener(postListener);


    }
}
