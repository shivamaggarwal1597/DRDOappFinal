package com.example.shivam.drdomapsproject;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SelectFile extends AppCompatActivity implements ShapeFileFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_file);
        ShapeFileFragment shapeFileFragment = new ShapeFileFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frame,shapeFileFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(ShapeListModel item) {
        String name = item.getShape_file_name();
        Intent intent = new Intent(SelectFile.this,ShowFile.class);
        intent.putExtra("val",name);
        startActivity(intent);
    }
}
