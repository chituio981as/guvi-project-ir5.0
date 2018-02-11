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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {
    private Button but;
    private EditText name,password;
    //Spinner spin;
    ListView listViewArtists1;
    DatabaseReference dataart;
    List<Artistt> artistListt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        dataart= FirebaseDatabase.getInstance().getReference("complain");
        name=(EditText)findViewById(R.id.editcomp);
       // spin=(Spinner) findViewById(R.id.spinner);
        but=(Button) findViewById(R.id.butt_compadd);
        listViewArtists1=(ListView)findViewById(R.id.listViewA) ;
        artistListt=new ArrayList<>();
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

                artistListt.clear();

                for(DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Artistt artist=artistSnapshot.getValue(Artistt.class);
                    artistListt.add(artist);
                }
                ArrayAdapter adapter=new Aritistlistt(Main12Activity.this,artistListt);
                listViewArtists1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void add(){
        String names=name.getText().toString().trim();
      //  String genres=spin.getSelectedItem().toString();

        if(!TextUtils.isEmpty(names)){
            String id=dataart.push().getKey();
            Artistt artist=new Artistt(id,names);
            dataart.child(id).setValue(artist);
            Toast.makeText(this,"complain added",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Invalid Data",Toast.LENGTH_LONG).show();
        }
    }
}
