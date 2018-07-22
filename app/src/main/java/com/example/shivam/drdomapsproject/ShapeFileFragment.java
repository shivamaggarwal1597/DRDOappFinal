package com.example.shivam.drdomapsproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ShapeFileFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    List<ShapeListModel> shapeListModels;
    private OnListFragmentInteractionListener mListener;
    Context context;

    public ShapeFileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shapeListModels = new ArrayList<>();
        shapeListModels.add(new ShapeListModel("landslide","It shows the past landslide occurences","Landslide Occurenecs"));
        shapeListModels.add(new ShapeListModel("uttarakhand_district","It shows the distrcts of uthrakhand","Utharakhand Districts"));
        shapeListModels.add(new ShapeListModel("anthro","It shows Anthrological data related to the site","Anthro Data"));
        shapeListModels.add(new ShapeListModel("aspect","It shows the Aspect Related Data to the site","Aspect"));
        shapeListModels.add(new ShapeListModel("drain","It shows the Drainage Data of the Site","Drainage Data"));
        // shapeListModels.add(new ShapeListModel("landslide","It shows the past landslide occurences","Landslide Occurenecs"));
        //shapeListModels.add(new ShapeListModel("landslide","It shows the past landslide occurences","Landslide Occurenecs"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new ShapeListAdapter(shapeListModels, mListener,context));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ShapeListModel item);
    }
}