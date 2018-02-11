package com.example.vijay.train;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] titles,titles1;
    String[] Des,Des1;
    ListView list;
    int[] images = {R.drawable.coim, R.drawable.salem, R.drawable.madurai,R.drawable.help,R.drawable.irctc,
            R.drawable.taxi
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        titles = res.getStringArray(R.array.titles);
        Des = res.getStringArray(R.array.description);

        list = (ListView) findViewById(R.id.listView);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //intent.putExtra("countryName", list.getItemAtPosition(i).toString());
                if(i==0)
                {
                    Intent inntend = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(inntend);
                }
                if(i==1)
                {
                    Intent intend = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(intend);
                }
                if(i==2)
                {
                    Intent intend = new Intent(MainActivity.this, Main4Activity.class);
                    startActivity(intend);
                }
                if(i==3)
                {
                    Intent intend = new Intent(MainActivity.this, Main5Activity.class);
                    startActivity(intend);
                }
                if(i==4)
                {
                    Intent browserIntnt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.irctc.co.in/eticketing/loginHome.jsf"));
                    startActivity(browserIntnt);
                }
                if(i==5)
                {
                    Intent intend = new Intent(MainActivity.this, Main16Activity.class);
                    startActivity(intend);
                }

            }
        });
        HAadapter aadapter=new HAadapter(this,titles,images,Des);
        list.setAdapter(aadapter);
    }

}
class  HAadapter extends ArrayAdapter<String>
{   int[] images;
    String[] titlea;
    String[] desa;
    Context context;
    HAadapter(Context c,String[] titles,int imag[],String[] desc)
    {
        super(c,R.layout.single_row,R.id.textView3,titles);
        this.context=c;
        this.images=imag;
        this.titlea=titles;
        this.desa=desc;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.single_row,parent,false);
        ImageView myimage=(ImageView) row.findViewById(R.id.imageView5);
        TextView mytitle=(TextView)row.findViewById(R.id.textView3);
        TextView mydes=(TextView)row.findViewById(R.id.textView4);

        myimage.setImageResource(images[position]);
        mytitle.setText(titlea[position]);
        mydes.setText(desa[position]);
        return row;
    }
}


