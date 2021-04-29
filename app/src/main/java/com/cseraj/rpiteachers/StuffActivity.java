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

public class StuffActivity extends AppCompatActivity {


    ListView listView;
    Adapter adapter;
    String[]title,desc,phone;
    int[]image;
    ArrayList <stuffs> arrayList=new ArrayList<stuffs>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff);


        listView=findViewById(R.id.list_view);

        title=new String[]{"Md Jahidul Islam","Monoara Parvin","Hosne Afroz","Shamim Ara Begum","Nousad Ali","Kamal Hosen","Rabeya Sultana","Taposhi Rabeya","Ajmal Haque","Nasima Choudhury","Shobnom Mostari","Bidhuvuson Sorkar"};
        desc=new String[]{"Draftsman","Accountant","High level Assistant","High level Asssistant","Librarian","Treasurer","Farmaciest","Storekipper","Kash Sectioner","Office Assistant","Office Assistant","Office Assistant"};
        phone=new String[]{"01558300889","01552498506","01715181967","01716373563","01552499742","01712213294","01816513439","01550002869","01710722855","01552602777","01550002883","01550019410"};
        image=new int[]{R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.female,R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.male};
        arrayList=new ArrayList<>();

        for (int i=0;i<title.length;i++){
            stuffs st=new stuffs(title[i],desc[i],phone[i],image[i]);
            arrayList.add(st);
        }
        adapter=new Adapter(this,arrayList);
        listView.setAdapter(adapter);





    }





    //Teachers.java
     public class  stuffs{
        String title;
        String desc;
        String phone;
        int image;

        public stuffs(String title, String desc, String phone, int image) {
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



        public Adapter(Context context, List<stuffs> teachersList) {
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
                view=layoutInflater.inflate(R.layout.stuff_row,null);

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
                    if (ActivityCompat.checkSelfPermission(StuffActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + holder.phone.getText().toString())));
                }
            });


            return view;
        }
    }

}
