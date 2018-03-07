package com.latentdev.d_check;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.latentdev.d_check.Model.Ride;

/**
 * Created by LatentDev on 3/7/2018.
 */

public class RideDetailViewModel extends BaseObservable {

    private Ride mRide;
    private String mLand;
    private String mDesigner;
    private String mOpening;
    private String mRideLength;
    private String mSponsor;
    private String mSummary;

    public RideDetailViewModel(Ride ride,String land, String designer, String opening, String rideLength, String sponsor, String summary)
    {
        setRide(ride);
        setLand(land);
        setDesigner(designer);
        setOpening(opening);
        setRideLength(rideLength);
        setSponsor(sponsor);
        setmSummary(summary);
    }

    @Bindable
    public String getRideName()
    {
        return mRide.getName();
    }
    @Bindable
    public String getLand()
    {
        return mLand;
    }
    @Bindable
    public String getDesigner()
    {
        return mDesigner;
    }
    @Bindable
    public String getOpening()
    {
        return mOpening;
    }
    @Bindable
    public String getRideLength()
    {
        return mRideLength;
    }
    @Bindable
    public String getSponsor()
    {
        return mSponsor;
    }
    @Bindable
    public String getSummary()
    {
        return mSummary;
    }

    public void setRide(Ride ride)
    {
        mRide = ride;
        notifyPropertyChanged(BR.rideName);
        //more ride stuff
    }

    public void setLand(String land)
    {
        mLand = land;
        notifyPropertyChanged(BR.land);
    }

    public void setDesigner(String designer)
    {
        mDesigner = designer;
        notifyPropertyChanged(BR.designer);
    }

    public void setOpening(String opening)
    {
        mOpening = opening;
        notifyPropertyChanged(BR.opening);
    }

    public void setRideLength(String rideLength)
    {
        mRideLength = rideLength;
        notifyPropertyChanged(BR.rideLength);
    }

    public void setSponsor(String sponsor)
    {
        mSponsor = sponsor;
        notifyPropertyChanged(BR.sponsor);
    }

    public void setmSummary(String summary)
    {
        mSummary = summary;
        notifyPropertyChanged(BR.summary);
    }

}
