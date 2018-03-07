package com.latentdev.d_check;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.latentdev.d_check.Model.Ride;
import com.latentdev.d_check.databinding.ListobjectBinding;

/**
 * Created by LatentDev on 7/27/2017.
 */


public class RideAdapter extends RecyclerView.Adapter<RideAdapter.BindingHolder> {

    private ObservableArrayList<Ride> mRides;
    private Context mContext;
    OnItemClickListener onItemClickListener;


    public RideAdapter(ObservableArrayList<Ride> mRides, Context mContext) {
        this.mRides = mRides;
        this.mContext = mContext;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListobjectBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.listobject, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClicked(v, mRides.get(position));
            }
        });
        ListobjectBinding binding = holder.binding;
        binding.setRvm(new RideViewModel(mRides.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mRides.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ListobjectBinding binding;

        public BindingHolder(ListobjectBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnItemClickListener {
        void OnItemClicked(View view, Ride ride);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

