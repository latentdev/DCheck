package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.latentdev.d_check.BR;

/**
 * Created by Laten on 7/26/2017.
 */

/*public class WaitTime extends BaseObservable {
    private FastPass fastPass;
    private String status;
    private boolean singleRider;
    private int waitTime;
    private String rollUpStatus;
    private String rollUpWaitTimeMessage;

    public FastPass getFastPass() {
        return fastPass;
    }

    public void setFastPass(FastPass fastPass) {
        this.fastPass = fastPass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSingleRider() {
        return singleRider;
    }

    public void setSingleRider(boolean singleRider) {
        this.singleRider = singleRider;
    }
    @Bindable
    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
        notifyPropertyChanged(BR.waitTime);
    }
    @Bindable
    public String getRollUpStatus() {
        return rollUpStatus;
    }

    public void setRollUpStatus(String rollUpStatus) {
        this.rollUpStatus = rollUpStatus;
        notifyPropertyChanged(BR.status);
    }
    @Bindable
    public String getRollUpWaitTimeMessage() {
        return rollUpWaitTimeMessage;
    }

    public void setRollUpWaitTimeMessage(String rollUpWaitTimeMessage) {
        this.rollUpWaitTimeMessage = rollUpWaitTimeMessage;
        notifyPropertyChanged(BR.message);
    }
}*/

public class WaitTime extends BaseObservable implements Parcelable {
    private FastPass fastPass;
    private String status;
    private boolean singleRider;
    private int waitTime;
    private String rollUpStatus;
    private String rollUpWaitTimeMessage;

    public WaitTime(){}

    public FastPass getFastPass() {
        return fastPass;
    }

    public void setFastPass(FastPass fastPass) {
        this.fastPass = fastPass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSingleRider() {
        return singleRider;
    }

    public void setSingleRider(boolean singleRider) {
        this.singleRider = singleRider;
    }
    @Bindable
    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
        notifyPropertyChanged(BR.waitTime);
    }
    @Bindable
    public String getRollUpStatus() {
        return rollUpStatus;
    }

    public void setRollUpStatus(String rollUpStatus) {
        this.rollUpStatus = rollUpStatus;
        notifyPropertyChanged(BR.status);
    }
    @Bindable
    public String getRollUpWaitTimeMessage() {
        return rollUpWaitTimeMessage;
    }

    public void setRollUpWaitTimeMessage(String rollUpWaitTimeMessage) {
        this.rollUpWaitTimeMessage = rollUpWaitTimeMessage;
        notifyPropertyChanged(BR.message);
    }


    protected WaitTime(Parcel in) {
        fastPass = (FastPass) in.readValue(FastPass.class.getClassLoader());
        status = in.readString();
        singleRider = in.readByte() != 0x00;
        waitTime = in.readInt();
        rollUpStatus = in.readString();
        rollUpWaitTimeMessage = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fastPass);
        dest.writeString(status);
        dest.writeByte((byte) (singleRider ? 0x01 : 0x00));
        dest.writeInt(waitTime);
        dest.writeString(rollUpStatus);
        dest.writeString(rollUpWaitTimeMessage);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WaitTime> CREATOR = new Parcelable.Creator<WaitTime>() {
        @Override
        public WaitTime createFromParcel(Parcel in) {
            return new WaitTime(in);
        }

        @Override
        public WaitTime[] newArray(int size) {
            return new WaitTime[size];
        }
    };
}