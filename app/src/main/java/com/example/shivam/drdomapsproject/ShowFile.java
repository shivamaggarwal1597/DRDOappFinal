package com.example.shivam.drdomapsproject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class ShowFile extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_file);
        Intent intent = getIntent();
        name =  intent.getStringExtra("val");
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
        retrieveFileFromResource();

    }

    private void retrieveFileFromResource() {
        try {
            switch (name){
                case "landslide":
                    KmlLayer kmlLayer1 = new KmlLayer(mMap, R.raw.landslide, getApplicationContext());
                    kmlLayer1.addLayerToMap();
                    break;
                case "uttarakhand_district":
                    KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.uttarakhand_district, getApplicationContext());
                    kmlLayer.addLayerToMap();
                    break;
                case "anthro":
                    KmlLayer kmlLayer2 = new KmlLayer(mMap, R.raw.anthro, getApplicationContext());
                    kmlLayer2.addLayerToMap();
                    break;
                case "aspect":
                    KmlLayer kmlLayer3 = new KmlLayer(mMap, R.raw.aspect, getApplicationContext());
                    kmlLayer3.addLayerToMap();
                    break;
                case "drain":
                    KmlLayer kmlLayer4 = new KmlLayer(mMap, R.raw.drain, getApplicationContext());
                    kmlLayer4.addLayerToMap();
                    break;
            }





            // moveCameraToKml(kmlLayer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
    private void moveCameraToKml(KmlLayer kmlLayer) {
        //Retrieve the first container in the KML layer
        KmlContainer container = kmlLayer.getContainers().iterator().next();

        if (container.hasProperties()) {
            Log.e("tag","true");
            Toast.makeText(ShowFile.this,"Has Property",Toast.LENGTH_LONG).show();
        }
        //Retrieve a nested container within the first container
       /*
        container = container.getContainers().iterator().next();
        //Retrieve the first placemark in the nested container
        KmlPlacemark placemark = container.getPlacemarks().iterator().next();
        //Retrieve a polygon object in a placemark
        KmlPolygon polygon = (KmlPolygon) placemark.getGeometry();
        //Create LatLngBounds of the outer coordinates of the polygon
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : polygon.getOuterBoundaryCoordinates()) {
            builder.include(latLng);
        }

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), width, height, 1));
    }*/
    }
}
