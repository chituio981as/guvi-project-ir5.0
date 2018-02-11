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

public class Main11Activity extends AppCompatActivity {
    ListView listViewArtists2;
    DatabaseReference dataart;
    List<Train> artistList2;
    private Button but;
    private EditText name,from,to,arrival,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        dataart= FirebaseDatabase.getInstance().getReference("MADURAI");
       but=(Button)findViewById(R.id.button_add2);
    /*    name=(EditText) findViewById(R.id.editText_name2);
        number=(EditText)findViewById(R.id.editText_number2);
        arrival=(EditText)findViewById(R.id.editText_arrival2);
        from=(EditText)findViewById(R.id.editText_from2);
        to=(EditText)findViewById(R.id.editText_to2);
*/
        listViewArtists2=(ListView)findViewById(R.id.listViewArtist2) ;
        artistList2=new ArrayList<>();
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

                 artistList2.clear();

                for(DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Train artist=artistSnapshot.getValue(Train.class);
                    artistList2.add(artist);
                }
                ArrayAdapter adapter=new Artistlist(Main11Activity.this,artistList2);
                listViewArtists2.setAdapter(adapter);
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
