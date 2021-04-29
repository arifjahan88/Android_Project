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

public class NonActivity extends AppCompatActivity {


    ListView listView;
    Adapter adapter;
    String[]title,desc,phone;
    int[]image;
    ArrayList<nonTeachers>arrayList=new ArrayList<nonTeachers>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non);


        listView=findViewById(R.id.list_view);

        title=new String[]{"Zamilur Rahman","Kabir Ahmmed","Jakia Sultana","Shamroz Nahar","Zahangir Alom","Parvez Ahmmed","Moin Uddin","Shahidul Islam","Alif Nur Khatun","Rajibul Alom"};
        desc=new String[]{"Teacher","Teacher","Teacher","Teacher","Teacher","Teacher","Teacher","Teacher","Teacher","Teacher",};
        phone=new String[]{"01716760544","01717136131","01765901850","01722795196","01721767670","01775588190","01737345728","01722777554","01745223830","01929940601"};
        image=new int[]{R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.male,};
        arrayList=new ArrayList<>();

        for (int i=0;i<title.length;i++){
            nonTeachers nonTeachers=new nonTeachers(title[i],desc[i],phone[i],image[i]);
            arrayList.add(nonTeachers);

        }
        adapter=new Adapter(this,arrayList);
        listView.setAdapter(adapter);

    }///emd of onCreate


    ////nonTeacher.java

    public class nonTeachers{

        String title,desc,phone;
        int image;


        public nonTeachers(String title, String desc, String phone, int image) {
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


    ///Adapter.java

    public class Adapter extends BaseAdapter {

        Context context;
        LayoutInflater layoutInflater;


        public Adapter(Context context, List<nonTeachers> teachersList) {
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

           final ViewHolder holder ;

            if(view==null){
                holder=new ViewHolder();
                view=layoutInflater.inflate(R.layout.non_row,null);

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
                    if (ActivityCompat.checkSelfPermission(NonActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + holder.phone.getText().toString())));
                }
            });


            return view;
        }
    }//end of Adapter


}
