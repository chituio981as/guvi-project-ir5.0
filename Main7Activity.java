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

public class Main7Activity extends AppCompatActivity {
    ListView listViewArtists;
    DatabaseReference dataart;
    List<Train> artistList;
    private Button but;
    private EditText name,from,to,arrival,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        dataart= FirebaseDatabase.getInstance().getReference("COIMBATORE");
      but=(Button)findViewById(R.id.button_add);
       /* name=(EditText) findViewById(R.id.editText_name);
        number=(EditText)findViewById(R.id.editText_number);
        arrival=(EditText)findViewById(R.id.editText_arrival);
        from=(EditText)findViewById(R.id.editText_from);
        to=(EditText)findViewById(R.id.editText_to);
   */
        listViewArtists=(ListView)findViewById(R.id.listViewArtist) ;
        artistList=new ArrayList<>();
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

               artistList.clear();

                for(DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Train artist=artistSnapshot.getValue(Train.class);
                    artistList.add(artist);
                }
                ArrayAdapter adapter=new Artistlist(Main7Activity.this,artistList);
                listViewArtists.setAdapter(adapter);
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
            Toast.makeText(this,"Data added",Toast.LENGTH_LONG).show();
        }
    }
}
