package com.cseraj.rpiteachers;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ElectricalActivity extends AppCompatActivity {


    ListView listView;
    Adapter adapter;
    String[]title,desc,phone;
    int[]image;
    ArrayList <elTeachers> arrayList=new ArrayList<elTeachers>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);


        listView=findViewById(R.id.list_view);

        title=new String[]{"Md Shahidul Islam","Ahmed Hossen","SM Ajom Ullah","Nur Islam","Najmul Hossain","Jakirul Islam","Moushumi Khatun","Sujon Kumar Boshak"};
        desc=new String[]{"Chief Instructor","Instructor","Junior Instructor","Junior Instructor","Junior Instructor","Assistant Teacher","Assistant Teacher","Workshop Super"};
        phone=new String[]{"01992006723","01550006829","01912800253","01556312672","01745677878","01738347355","01745932609","01732397300"};
        image=new int[]{R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.male};
        arrayList=new ArrayList<>();


        for (int i=0;i<title.length;i++){
            elTeachers cvTeachers=new elTeachers(title[i],desc[i],phone[i],image[i]);
            arrayList.add(cvTeachers);
        }
        adapter=new Adapter(this,arrayList);
        listView.setAdapter(adapter);





    }



    //elTeachers.java
    public  class  elTeachers{
        String title;
        String desc;
        String phone;
        int image;

        public elTeachers(String title, String desc, String phone, int image) {
            this.title = title;
            this.desc = desc;
            this.phone = phone;
            this.image = image;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getPhone() {
            return this.phone;
        }

        public int getImage() {
            return this.image;
        }

    }


    ///Adapter class

    public class Adapter extends BaseAdapter {


        Context context;
        LayoutInflater layoutInflater;



        public Adapter(Context context, List<elTeachers> teachersList) {
            this.context = context;
            layoutInflater=LayoutInflater.from(context);



        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder{
            TextView title,desc,phone;
            ImageView image;
            Button call;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

             final ViewHolder holder;
            if(view==null){
                holder=new ViewHolder();
                view=layoutInflater.inflate(R.layout.el_row,null);

                holder.title=view.findViewById(R.id.name);
                holder.desc=view.findViewById(R.id.desc);
                holder.phone=view.findViewById(R.id.phone);
                holder.image=view.findViewById(R.id.picture);
                holder.call=view.findViewById(R.id.call);

                view.setTag(holder);
            }
            else {
                holder= (ViewHolder) view.getTag();
            }
            holder.title.setText(arrayList.get(position).getTitle());
            holder.desc.setText(arrayList.get(position).getDesc());
            holder.phone.setText(arrayList.get(position).getPhone());
            holder.image.setImageResource(arrayList.get(position).getImage());
            holder.call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ActivityCompat.checkSelfPermission(ElectricalActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + holder.phone.getText().toString())));
                }
            });


            return view;
        }
    }



}
