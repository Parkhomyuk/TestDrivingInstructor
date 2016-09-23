package com.example.testdrivingfloatingbuttom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3,fab4;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    GoogleMap googleMap;
    boolean mapReady=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);



    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                Intent intentSign= new Intent(MainActivity.this,MaterialDesignSignUpRegistrationFormXMLUI.class);
                startActivity(intentSign);
                Log.d("Fab", "Sign in");
                break;
            case R.id.fab2:
                Intent intent = new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
                Log.d("Fab", "Map");
                break;
            case R.id.fab3:

                Log.d("Fab", "Fab 3");
                break;

        case R.id.fab4:
            Intent intentAdapt = new Intent(MainActivity.this,InstructorAdapterActivity.class);
            startActivity(intentAdapt);
        Log.d("AdapterInstructors", "Fab 4");
        break;
    }
    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady=true;
        googleMap=map;
        LatLng ny= new LatLng(40.7484,-73.9857);

        CameraPosition target= CameraPosition.builder().target(ny).zoom(7).build();




        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));

    }
}
