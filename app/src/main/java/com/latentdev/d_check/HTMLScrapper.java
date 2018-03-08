package com.latentdev.d_check;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.latentdev.d_check.Model.Ride;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutionException;

/**
 * Created by LatentDev on 3/7/2018.
 */

public class HTMLScrapper {
    private Document mDocument;
    private Object lock = new Object();

    public HTMLScrapper()
    {

    }

    public RideDetailViewModel ParseDetails(Ride ride, Document document)
    {
        RideDetailViewModel rideDetailViewModel = new RideDetailViewModel(ride);
        mDocument = document;
        Elements tables = mDocument.getElementsByClass("infobox");
        Element infoTable = tables.first();
        ArrayList<String> text = new ArrayList<>();
        if(infoTable!=null) {
            for (Element e : infoTable.getElementsByTag("td")) {
                text.add(e.text());
            }
            rideDetailViewModel = SetDetails(rideDetailViewModel, text);
        }
        return rideDetailViewModel;
    }

    public static RideDetailViewModel SetDetails(RideDetailViewModel rideDetailViewModel, ArrayList<String> details)
    {
        int index = 0;
        for(String detail:details)
        {

            switch(detail)
            {
                case "Land":
                {
                    rideDetailViewModel.setLand(details.get(index+1));
                    break;
                }
                case "Designer":
                {
                    rideDetailViewModel.setDesigner(details.get(index+1));
                    break;
                }
                case "Opening date":
                {
                    rideDetailViewModel.setOpening(details.get(index+1));
                    break;
                }
                case "Vehicle capacity":
                {
                    rideDetailViewModel.setRideCapacity(details.get(index+1));
                    break;
                }
                case "Ride duration":
                {
                    rideDetailViewModel.setRideLength(details.get(index+1));
                    break;
                }
                case "Sponsored by":
                {
                    rideDetailViewModel.setSponsor(details.get(index+1));
                    break;
                }
            }
            index++;
        }
        return rideDetailViewModel;
    }
    public String GetLink(Document document)
    {
        Elements results = document.getElementsByClass("result-link");
        String url = results.first().attr("href");
        return url;
    }
}
