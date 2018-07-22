package com.example.shivam.drdomapsproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shivam.drdomapsproject.ShapeFileFragment.OnListFragmentInteractionListener;


import java.util.List;

public class ShapeListAdapter extends RecyclerView.Adapter<ShapeListAdapter.ViewHolder> {

    private final List<ShapeListModel> mValues;
    TinyDB tinyDB ;
    private final OnListFragmentInteractionListener mListener;
    DAOmodelShapeFile daOmodelShapeFile;

    public ShapeListAdapter(List<ShapeListModel> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        tinyDB = new TinyDB(context);
        daOmodelShapeFile = new DAOmodelShapeFile();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getShow_name());
        holder.mContentView.setText(mValues.get(position).getShape_file_details());
        if (mValues.get(position).isSelected_to_show()){
            holder.select_btn.setBackgroundColor(R.color.colorPrimary);
            holder.select_btn.setText("SELECTED");
            Log.e("Selected",mValues.get(position).isSelected_to_show()+"");
        }
        else if (!mValues.get(position).isSelected_to_show()){
            holder.select_btn.setBackgroundColor(R.color.unselect);
            holder.select_btn.setText("TAP TO SELECT");

        }
        holder.view_on_map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
        holder.select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mValues.get(position).isSelected_to_show()){
                    mValues.get(position).setSelected_to_show(false);
                    holder.select_btn.setBackgroundColor(R.color.colorPrimary);
                    holder.select_btn.setText("SELECTED");


                }
                else if (!mValues.get(position).isSelected_to_show()){
                    mValues.get(position).setSelected_to_show(true);
                    holder.select_btn.setBackgroundColor(R.color.unselect);
                    holder.select_btn.setText("TAP TO SELECT");
                }
                daOmodelShapeFile.setShapeListModels(mValues);
                tinyDB.putObject("dao_shape_file_selected",daOmodelShapeFile);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final Button view_on_map_button;
        public final TextView mContentView;
        public final Button select_btn;
        public ShapeListModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            select_btn = (Button)view.findViewById(R.id.select_btn);
            view_on_map_button = (Button)view.findViewById(R.id.view_on_map_button);
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}