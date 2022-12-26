package com.unlucky.assignment3.user.buyer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.unlucky.assignment3.R;
import com.unlucky.assignment3.shoe.Shoe;
import com.unlucky.assignment3.utilities.DownloadImageTask;

import java.util.List;

public class ShoeRecyclerViewAdapter extends RecyclerView.Adapter<ShoeRecyclerViewAdapter.ViewHolder> {
    private List<Shoe> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    ShoeRecyclerViewAdapter(Context context, List<Shoe> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.shoeNameRecycle.setText(mData.get(position).getName());
        holder.shoePriceRecycle.setText(mData.get(position).getPriceString());
        new DownloadImageTask(holder.shoeImageRecycle)
                .execute(mData.get(position).getPictureLink());

        System.out.println(mData.get(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shoeNameRecycle, shoePriceRecycle;
        ImageView shoeImageRecycle;

        ViewHolder(View itemView) {
            super(itemView);
            shoeNameRecycle = itemView.findViewById(R.id.shoeNameRecylce);
            shoeImageRecycle = itemView.findViewById(R.id.shoeImageRecycle);
            shoePriceRecycle = itemView.findViewById(R.id.shoePriceRecycle);
        }
    }
}