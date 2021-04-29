package com.cseraj.rpiteachers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TeachersActivity extends AppCompatActivity  implements View.OnClickListener{

   TextView textView;
   Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);


        textView = findViewById(R.id.tv);
        btn1 = findViewById(R.id.cmt);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.civ);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.el);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.et);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.em);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.mn);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.mt);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.pw);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.non);
        btn9.setOnClickListener(this);





    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.cmt:
                Intent intent1=new Intent(TeachersActivity.this,ComputerActivity.class);
                Toast.makeText(this,"This is Computer Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent1);
                break;


            case R.id.civ:
                Intent intent2=new Intent(TeachersActivity.this,CivilActivity.class);
                Toast.makeText(this,"This is Civil Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                break;

            case R.id.el:
                Intent intent3=new Intent(TeachersActivity.this,ElectricalActivity.class);
                Toast.makeText(this,"This is Electrical Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                break;

            case R.id.et:
                Intent intent4=new Intent(TeachersActivity.this,ElectronicsActivity.class);
                Toast.makeText(this,"This is Electronics Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                break;


            case R.id.em:
                Intent intent5=new Intent(TeachersActivity.this,ElectromedicalActivity.class);
                Toast.makeText(this,"This is Electromedical Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent5);
                break;

            case R.id.mn:
                Intent intent6=new Intent(TeachersActivity.this,MechanicalActivity.class);
                Toast.makeText(this,"This is Mechanical Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                break;

            case R.id.mt:
                Intent intent7=new Intent(TeachersActivity.this,MechatronicsActivity.class);
                Toast.makeText(this,"This is Mechatronics Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent7);
                break;

            case R.id.pw:
                Intent intent8=new Intent(TeachersActivity.this,PowerActivity.class);
                Toast.makeText(this,"This is Power Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent8);
                break;

            case R.id.non:
                Intent intent9=new Intent(TeachersActivity.this,NonActivity.class);
                Toast.makeText(this,"This is Non_Tech Teacher's list",Toast.LENGTH_SHORT).show();
                startActivity(intent9);
                break;




        }


    }


}
