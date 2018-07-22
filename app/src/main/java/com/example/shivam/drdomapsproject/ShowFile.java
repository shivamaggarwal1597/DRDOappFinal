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
    Intent intent;
    TinyDB tinyDB;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_file);
        intent = getIntent();
        type = intent.getStringExtra("type");
        tinyDB = new TinyDB(ShowFile.this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (type.equals("single")){
            String name =  intent.getStringExtra("val");
            Log.e("Testing:"," in single clause ");
            retrieveSingleFileFromResource(name);
        }
        else if (type.equals("multiple")){
            Log.e("Testing:"," in mutiple clause ");
            retrieveMultipleFileFromResource();
        }
        LatLng first = new LatLng(30.0869,78.2676);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(first));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8), 2000, null);


    }

    private void retrieveSingleFileFromResource(String name) {
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }


    public void retrieveMultipleFileFromResource(){
        DAOmodelShapeFile daOmodelShapeFile = tinyDB.getObject("dao_shape_file_selected",DAOmodelShapeFile.class);
        Log.e("Inside multiple func","true"+daOmodelShapeFile.getShapeListModels().size());
        for (ShapeListModel shapeListModel: daOmodelShapeFile.getShapeListModels()){
            Log.e("Inside for loop","true");
            if (shapeListModel.isSelected_to_show()){
                Log.e("Testing Show",shapeListModel.getShow_name()+"  "+shapeListModel.isSelected_to_show());
                retrieveSingleFileFromResource(shapeListModel.getShape_file_name());
            }

        }
    }
}