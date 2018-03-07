package com.latentdev.d_check;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.latentdev.d_check.Model.Ride;

/**
 * Created by LatentDev on 8/3/2017.
 */

public class RideViewModel extends BaseObservable {
    private Ride mRide;
    private Context mContext;

    public RideViewModel(Ride mRide, Context mContext) {
        this.mRide = mRide;
        this.mContext = mContext;
    }

    @Bindable
    public String getTitle() {
        return mRide.getName();
    }
    @Bindable
    public String getWaitTime() { return mRide.getWaitTime().getWaitTime() + " minutes"; }
    @Bindable
    public String getStatus() { return mRide.getWaitTime().getRollUpStatus(); }
    @Bindable
    public String getMessage() { return mRide.getWaitTime().getRollUpWaitTimeMessage(); }
    @Bindable
    public boolean getCheck() { return mRide.isCheck();}
    @Bindable
    public void setCheck(boolean check)
    {
        mRide.setCheck(check);
    }
}
