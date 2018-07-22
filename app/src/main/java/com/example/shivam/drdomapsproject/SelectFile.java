package com.example.shivam.drdomapsproject;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

public class SelectFile extends AppCompatActivity implements ShapeFileFragment.OnListFragmentInteractionListener{
    Button show_selected_button;
    DAOmodelShapeFile daOmodelShapeFile;
    TinyDB tinyDB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_file);
        tinyDB = new TinyDB(SelectFile.this);
        show_selected_button =  (Button)findViewById(R.id.show_selected_button);
        show_selected_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daOmodelShapeFile =  tinyDB.getObject("dao_shape_file_selected",DAOmodelShapeFile.class);
                Log.e("Testing",daOmodelShapeFile.getShapeListModels().size()+" ");
                if (daOmodelShapeFile.getShapeListModels().size()==0){
                    new MaterialDialog.Builder(SelectFile.this)
                            .title("Important Information")
                            .content("Please Select At Least One File To View")
                            .positiveText("OK")
                            .show();
                }else {

                    Intent intent = new Intent(SelectFile.this,ShowFile.class);
                    intent.putExtra("type","multiple");
                    startActivity(intent);
                }

            }
        });
        ShapeFileFragment shapeFileFragment = new ShapeFileFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frame,shapeFileFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(ShapeListModel item) {
        String name = item.getShape_file_name();
        Intent intent = new Intent(SelectFile.this,ShowFile.class);
        intent.putExtra("val",name);
        intent.putExtra("type","single");
        startActivity(intent);
    }
}