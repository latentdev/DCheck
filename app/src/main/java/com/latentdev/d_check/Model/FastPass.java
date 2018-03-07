package com.latentdev.d_check.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Laten on 7/26/2017.
 */

/*public class FastPass {


    private Date start;
    private Date end;
    private boolean available;

    public Date getStart()
    {
        return this.start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}*/

public class FastPass implements Parcelable {


    private Date start;
    private Date end;
    private boolean available;

    public Date getStart()
    {
        return this.start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public FastPass() {}

    public FastPass(Parcel in) {
        long tmpStart = in.readLong();
        start = tmpStart != -1 ? new Date(tmpStart) : null;
        long tmpEnd = in.readLong();
        end = tmpEnd != -1 ? new Date(tmpEnd) : null;
        available = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(start != null ? start.getTime() : -1L);
        dest.writeLong(end != null ? end.getTime() : -1L);
        dest.writeByte((byte) (available ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FastPass> CREATOR = new Parcelable.Creator<FastPass>() {
        @Override
        public FastPass createFromParcel(Parcel in) {
            return new FastPass(in);
        }

        @Override
        public FastPass[] newArray(int size) {
            return new FastPass[size];
        }
    };
}