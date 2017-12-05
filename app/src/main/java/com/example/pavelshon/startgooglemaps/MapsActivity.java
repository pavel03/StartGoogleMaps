package com.example.pavelshon.startgooglemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng other = new LatLng(-35, 150);

        //MarkerOptions o = new MarkerOptions().icon()
        mMap.addMarker(new MarkerOptions().position(sydney).title("Rider"));
        mMap.addMarker(new MarkerOptions().position(other).title("Car"));


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        PolylineOptions lineOptions = new PolylineOptions();
        lineOptions.add(sydney);
        lineOptions.add(other);
        mMap.addPolyline(lineOptions);
        //LatLng middle = midPoint(sydney,other);
        LatLngBounds bounds = new LatLngBounds(other,sydney);
        LatLng middle = bounds.getCenter();
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(middle,10));
        //mMap.setMinZoomPreference(15);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,100));


    }
    public static LatLng midPoint(LatLng location1,LatLng location2){

        double lat1 = location1.latitude;
        double lat2 = location2.latitude;
        double lon1 = location1.longitude;
        double lon2 = location2.longitude;
//        double dLon = Math.toRadians(lon2 - lon1);

        //convert to radians
//        lat1 = Math.toRadians(lat1);
//        lat2 = Math.toRadians(lat2);
//        lon1 = Math.toRadians(lon1);
//
//        double Bx = Math.cos(lat2) * Math.cos(dLon);
//        double By = Math.cos(lat2) * Math.sin(dLon);
//        double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
//        double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
//        LatLng middle = new LatLng(lat3,lon3);
        //pavels code
        double lat3 = (lat1 + lat2)/2;
        double lon3 = (lon1 + lon2)/2;
        LatLng middle = new LatLng(lat3,lon3);
        return middle;
        //print out in degrees
        //System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(lon3));
    }
}
