package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.latentdev.d_check.BR;

/**
 * Created by LatentDev on 7/23/2017.
 */

/*public class Ride extends BaseObservable {
    private int id;
    private String name;
    private String type;
    private WaitTime waitTime;
    private boolean check;

    public Ride()
    {
        check = false;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Bindable
    public WaitTime getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(WaitTime waitTime) {
        this.waitTime = waitTime;
    }
    @Bindable
    public boolean isCheck() {
        return check;
    }
    @Bindable
    public void setCheck(boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }
}*/

public class Ride extends BaseObservable implements Parcelable {
    private int id;
    private String name;
    private String type;
    private WaitTime waitTime;
    private boolean check;

    public Ride()
    {
        check = false;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        //notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Bindable
    public WaitTime getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(WaitTime waitTime) {
        this.waitTime = waitTime;
    }
    @Bindable
    public boolean isCheck() {
        return check;
    }
    @Bindable
    public void setCheck(boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }

    protected Ride(Parcel in) {
        id = in.readInt();
        name = in.readString();
        type = in.readString();
        waitTime = (WaitTime) in.readValue(WaitTime.class.getClassLoader());
        check = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeValue(waitTime);
        dest.writeByte((byte) (check ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Ride> CREATOR = new Parcelable.Creator<Ride>() {
        @Override
        public Ride createFromParcel(Parcel in) {
            return new Ride(in);
        }

        @Override
        public Ride[] newArray(int size) {
            return new Ride[size];
        }
    };
}
