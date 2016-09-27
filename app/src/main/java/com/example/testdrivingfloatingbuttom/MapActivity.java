package com.example.testdrivingfloatingbuttom;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by Кирилл on 17.09.2016.
 */
public class MapActivity extends Activity implements OnMapReadyCallback {
    GoogleMap googleMap;
    boolean mapReady=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        MapFragment mapFragment= (MapFragment)getFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady=true;
        googleMap=map;
        LatLng ny= new LatLng(32.08088,34.78057);

        CameraPosition target= CameraPosition.builder().target(ny).zoom(8).build();




        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));


    }
}
