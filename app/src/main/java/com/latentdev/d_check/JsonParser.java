package com.latentdev.d_check.Model;

import android.databinding.ObservableArrayList;
import android.os.Parcel;
import android.util.Log;

import com.latentdev.d_check.Model.Ride;
import com.latentdev.d_check.Model.WaitTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Date;


/**
 * Created by Laten on 7/27/2017.
 */

public class JsonParser
{
    static public void getRides(String json,ObservableArrayList<Ride> inRides)
    {
        //ObservableArrayList<Ride> rides= new ObservableArrayList<>();
        JSONTokener tokener = new JSONTokener(json);

        try{
            JSONArray array = (JSONArray) tokener.nextValue();
            int i = 0;
            while (!array.isNull(i)) {
                JSONObject object = (JSONObject) array.getJSONObject(i);
                if(object!=null) {
                    Ride ride = new Ride();
                    ride.setId(object.getInt("id"));
                    ride.setName(object.getString("name"));
                    ride.setType(object.getString("type"));

                    JSONObject jWaitTime = object.getJSONObject("waitTime");
                    if(jWaitTime!=null) {
                        JSONObject jFastPass = jWaitTime.getJSONObject("fastPass");
                        if (jFastPass != null) {
                            FastPass fastPass = new FastPass();
                            if(jFastPass.getString("start")!="null")
                                fastPass.setStart((Date) jFastPass.get("start"));
                            if(jFastPass.getString("end")!="null")
                                fastPass.setEnd((Date) jFastPass.get("end"));
                            fastPass.setAvailable(jFastPass.getBoolean("available"));

                            WaitTime waitTime = new WaitTime();
                            waitTime.setFastPass(fastPass);
                            waitTime.setStatus(jWaitTime.getString("status"));
                            waitTime.setSingleRider(jWaitTime.getBoolean("singleRider"));
                            waitTime.setWaitTime(jWaitTime.getInt("postedWaitMinutes"));
                            waitTime.setRollUpStatus(jWaitTime.getString("rollUpStatus"));
                            waitTime.setRollUpWaitTimeMessage(jWaitTime.getString("rollUpWaitTimeMessage"));
                            ride.setWaitTime(waitTime);
                        }
                    }
                    i++;

                    boolean found = false;
                    for (Ride mRide:inRides) {
                        if(mRide.getName().equals(ride.getName()))
                        {
                            if(mRide.getWaitTime().getWaitTime()!=ride.getWaitTime().getWaitTime())
                                Log.d("Update",mRide.getName()+" Updated! Old Time = "+mRide.getWaitTime().getWaitTime()+" New Time = "+ride.getWaitTime().getWaitTime());
                            mRide.setName(ride.getName());
                            mRide.getWaitTime().setWaitTime(ride.getWaitTime().getWaitTime());
                            mRide.getWaitTime().setRollUpWaitTimeMessage(ride.getWaitTime().getRollUpWaitTimeMessage());
                            mRide.getWaitTime().setRollUpStatus(ride.getWaitTime().getRollUpStatus());

                            found = true;
                        }
                        
                    }
                    if(found==false)
                    inRides.add(ride);
                }
            }

        }catch (JSONException e)
        {
            Log.e("error",e.toString());
        }

    }

}
