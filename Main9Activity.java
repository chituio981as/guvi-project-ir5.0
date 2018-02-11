package com.example.vijay.train;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
//import com.firebase.client.Firebase;
import com.example.vijay.train.Train;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.*;

import java.util.ArrayList;
import java.util.List;

public class Main9Activity extends AppCompatActivity {
    ListView listViewArtists1;
    DatabaseReference dataart;
    List<Train> artistList1;
    private Button but;
    private EditText name,from,to,arrival,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        dataart= FirebaseDatabase.getInstance().getReference("SALEM");
       but=(Button)findViewById(R.id.button_add1);
       /* name=(EditText) findViewById(R.id.editText_name1);
        number=(EditText)findViewById(R.id.editText_number1);
        arrival=(EditText)findViewById(R.id.editText_arrival1);
        from=(EditText)findViewById(R.id.editText_from1);
        to=(EditText)findViewById(R.id.editText_to1);
*/
        listViewArtists1=(ListView)findViewById(R.id.listViewArtist1) ;
        artistList1=new ArrayList<>();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataart.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artistList1.clear();

                for(DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Train artist=artistSnapshot.getValue(Train.class);
                    artistList1.add(artist);
                }
                ArrayAdapter adapter=new Artistlist(Main9Activity.this,artistList1);
                listViewArtists1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void add(){
        String names=name.getText().toString().trim();
        String numbers=number.getText().toString().trim();
        String arrivals=arrival.getText().toString().trim();
        String froms=from.getText().toString().trim();
        String tos=to.getText().toString().trim();


        if(!TextUtils.isEmpty(names)){
            String id=dataart.push().getKey();
            Train artist=new Train(id,numbers,arrivals,froms,tos,names);
            dataart.child(id).setValue(artist);
            Toast.makeText(this,"data added",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Data not added",Toast.LENGTH_LONG).show();
        }
    }
}
