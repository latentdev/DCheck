package com.latentdev.d_check;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.latentdev.d_check.Model.Ride;
import com.latentdev.d_check.databinding.ActivityRideDetailBinding;
import com.latentdev.d_check.databinding.FragmentSettingsBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RideDetailActivity extends AppCompatActivity {

    private Ride mRide;
    private String mContent;
    Document mDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle extras = getIntent().getExtras();
        mRide = extras.getParcelable("ride");
        //toolbar.setTitle(mRide.getName());
        setSupportActionBar(toolbar);
        //handle unique urls like chip 'n dale's treehouse = chip_n'_dale's_treehouse or the case where there is no info box
        final String url = "http://disneyparks.wikia.com/wiki/"+mRide.getName().replace(" ","_").replace("\"","");
//        try {
//            mDocument = new HTMLAsyncTask().execute(url).get();
//            if(!mDocument.toString().contains("class=\"infobox\""))
//            {
//                mDocument = new HTMLAsyncTask().execute(url+"_(Disneyland_Park)").get();
//                if(!mDocument.toString().contains("class=\"infobox\""))
//                {
//                    mDocument=null;
//                }
//            }
//
//            //mDocument = Jsoup.parse(mContent);
//        }catch(ExecutionException e) { Log.d("Network",e.getMessage()); }
//        catch(InterruptedException e) { Log.d("Network",e.getMessage()); }
        String searchQuery = mRide.getName().replace("Walt Disney ","").replace("Walt Disney's ","").replace(" ","+").replace("\"","")+"+Disneyland";

        GetDocument(searchQuery);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//        Elements tables = mDocument.getElementsByClass("infobox");
//        Element infoTable = tables.first();
//        ArrayList<String> text = new ArrayList<>();
//        for(Element e:infoTable.getElementsByTag("td"))
//        {
//            text.add(e.text());
//        }//children().get(0).children().get(3).children().get(1).children().get(0).attr("title");//.children().get(6); //.select("b[text=Land]").first().parent()
//        Elements summary = mDocument.getElementById("Summary").children();
//        String lines = new String();
//        for(Element e:summary)
//        {
//            lines += (e.text() + "\\n\\n");
//        }
        RideDetailViewModel vm;

        if(mDocument != null) {
            vm = new HTMLScrapper().ParseDetails(mRide, mDocument); //new RideDetailViewModel(mRide,text.get(4), text.get(6), text.get(8), text.get(14), text.get(18), lines );
        }else
        {
            vm = new RideDetailViewModel(mRide);
        }
        ActivityRideDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ride_detail);

        binding.setViewModel(vm);

        //text.size();


    }

    private void GetDocument(String ride)
    {
        String url = "http://disneyparks.wikia.com/wiki/Special:Search?query="+ride;
        try{
            mDocument = new HTMLAsyncTask().execute(url).get();
        }catch(ExecutionException e) { Log.d("Network",e.getMessage()); }
        catch(InterruptedException e) { Log.d("Network",e.getMessage()); }
        if(mDocument!=null)
        {
            url = new HTMLScrapper().GetLink(mDocument);
        }
        try{
            mDocument = new HTMLAsyncTask().execute(url).get();
        }catch(ExecutionException e) { Log.d("Network",e.getMessage()); }
        catch(InterruptedException e) { Log.d("Network",e.getMessage()); }
    }
}
