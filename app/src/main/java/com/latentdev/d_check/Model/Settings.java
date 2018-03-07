package com.latentdev.d_check.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.latentdev.d_check.BR;

/**
 * Created by Laten on 8/17/2017.
 */

public class Settings extends BaseObservable {

    public int interval;
    public boolean keepTimesUpdated;
    Settings()
    {
        interval = 5;
        setKeepTimesUpdated(false);
    }

    @Bindable
    public boolean getKeepTimesUpdated()
    {
        return keepTimesUpdated;
    }

    public void setKeepTimesUpdated(boolean value)
    {
        keepTimesUpdated = value;
        notifyPropertyChanged(BR.keepTimesUpdated);
    }
}
