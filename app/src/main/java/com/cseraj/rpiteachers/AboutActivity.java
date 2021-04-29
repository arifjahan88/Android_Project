package com.cseraj.rpiteachers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String [] item= {"Location : Sopura,Rajshahi.",
                "Situated : 1963",
                "Department : 8 ",
                "Seat Number :- ",
                               "Computer : 120" ,
                               "Civil : 240",
                               "Electrical : 240",
                               "Electronics : 120",
                               "Electromedical : 120",
                               "Mechanical : 120",
                               "Mechatronics : 120",
                               "Power : 120"



        };

        ListView about=findViewById(R.id.list_about);
        ArrayAdapter<String > rpi=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
        about.setAdapter(rpi);
        about.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item= ((TextView)view).getText().toString();
    }
}
