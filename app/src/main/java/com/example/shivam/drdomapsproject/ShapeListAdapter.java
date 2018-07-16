package com.example.shivam.drdomapsproject;

import android.annotation.SuppressLint;
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
    private final OnListFragmentInteractionListener mListener;

    public ShapeListAdapter(List<ShapeListModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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
            holder.mView.setBackgroundColor(R.color.colorPrimary);
            Log.e("Selected",mValues.get(position).isSelected_to_show()+"");
        }

        holder.view_on_map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onLongClick(View view) {

                if (mValues.get(position).isSelected_to_show()){
                    mValues.get(position).setSelected_to_show(false);
                }
                else {
                    mValues.get(position).setSelected_to_show(true);
                }
                notifyDataSetChanged();
                return false;
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
        public ShapeListModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
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
