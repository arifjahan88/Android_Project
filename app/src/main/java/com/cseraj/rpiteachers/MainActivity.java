package com.cseraj.rpiteachers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{

    Button btn1, btn2, btn3, btn4;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    PermissionManager permissionManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.teach_list);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.stuff_list);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.officer_list);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.workers_list);
        btn4.setOnClickListener(this);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(toggle);

        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        toggle.syncState();

        permissionManager = new PermissionManager() {};
        permissionManager.checkAndRequestPermissions(this);


    }//end of onCreate

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult(requestCode,permissions,grantResults);

        ArrayList<String> granted = permissionManager.getStatus().get(0).granted;
        ArrayList<String> denied = permissionManager.getStatus().get(0).denied;
    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.teach_list:
                Intent intent1 = new Intent(MainActivity.this, TeachersActivity.class);
                Toast.makeText(this, "This is Teacher's list", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
                break;

            case R.id.stuff_list:
                Intent intent2 = new Intent(MainActivity.this, StuffActivity.class);
                Toast.makeText(this, "This is Stuff's list", Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                break;

            case R.id.officer_list:
                Intent intent3 = new Intent(MainActivity.this, OfficerActivity.class);
                Toast.makeText(this, "This is Officer's list", Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                break;

            case R.id.workers_list:
                Intent intent4 = new Intent(MainActivity.this, WorkerActivity.class);
                Toast.makeText(this, "This is Worker's list", Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                break;


        }


    }///onClickView


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to exit the app ??")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null).setCancelable(false);
            AlertDialog alert = builder.create();
            alert.show();


        }//onBackPressed


        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about:
                Intent intent1=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent1);
                break;

            case R.id.item_web:
                Intent intent2=new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent2);
                break;

            case R.id.item_dev:
                Intent intent3=new Intent(MainActivity.this,DeveloperActivity.class);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }
    ///onOptionItemSelected


    }


