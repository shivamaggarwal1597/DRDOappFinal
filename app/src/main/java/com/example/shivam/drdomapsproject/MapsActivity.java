package com.example.shivam.drdomapsproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TinyDB tinyDB;
    List<LocationModel> locationModels;
    DAOModel daoModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        tinyDB = new TinyDB(MapsActivity.this);
        daoModel = tinyDB.getObject("dao",DAOModel.class);
        locationModels =  daoModel.getLocation_models();
        Log.e("Location Model Size:"," "+locationModels.size());
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


            LatLng a = new LatLng(locationModels.get(0).getLatitude(),locationModels.get(0).getLongitude());
            LatLng b = new LatLng(locationModels.get(1).getLatitude(),locationModels.get(1).getLongitude());
            LatLng c = new LatLng(locationModels.get(2).getLatitude(),locationModels.get(2).getLongitude());
            LatLng d = new LatLng(locationModels.get(3).getLatitude(),locationModels.get(3).getLongitude());
            LatLng e = new LatLng(locationModels.get(4).getLatitude(),locationModels.get(4).getLongitude());
            LatLng f = new LatLng(locationModels.get(5).getLatitude(),locationModels.get(5).getLongitude());
            LatLng g = new LatLng(locationModels.get(6).getLatitude(),locationModels.get(6).getLongitude());

            mMap.addMarker(new MarkerOptions()
                        .position(a).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        .title("status:  " + locationModels.get(0).getResult()));
                Log.e("Added ", "true" + a.latitude+" "+a.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(b).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(1).getResult()));
        Log.e("Added ", "true" + b.latitude+" "+b.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(c).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(2).getResult()));
        Log.e("Added ", "true" + c.latitude+" "+c.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(d).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(3).getResult()));
        Log.e("Added ", "true" + d.latitude+" "+d.longitude);mMap.addMarker(new MarkerOptions()
                .position(e).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(4).getResult()));
        Log.e("Added ", "true" + e.latitude+" "+e.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(f).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(5).getResult()));
        Log.e("Added ", "true" + f.latitude+" "+f.longitude);
        mMap.addMarker(new MarkerOptions()
                .position(g).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title("status:  " + locationModels.get(6).getResult()));
        Log.e("Added ", "true" + g.latitude+" "+g.longitude);
        //retrieveFileFromResource();
        LatLng sydney = new LatLng(locationModels.get(3).getLatitude(),locationModels.get(3).getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    private void retrieveFileFromResource() {
        try {
            KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.uttarakhand_district, getApplicationContext());
            KmlLayer kmlLayer1 = new KmlLayer(mMap, R.raw.landslide, getApplicationContext());

            kmlLayer.addLayerToMap();
            kmlLayer1.addLayerToMap();
           // moveCameraToKml(kmlLayer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

}
