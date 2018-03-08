package com.latentdev.d_check;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by LatentDev on 3/8/2018.
 */


public class HTMLAsyncTask extends AsyncTask<String,String,Document> {
    @Override
    protected Document doInBackground(String... urls) {
        Document document = null;
        try {
            document = Jsoup.connect(urls[0]).userAgent("Mozilla/5.0 (Linux; Android 8.0.0) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Focus/1.3 Chrome/61.0.3163.81 Mobile Safari/537.36").get();
            return document;
        } catch (IOException e) {
            Log.d("HTMLScrapper", e.getMessage());
        }
        return document;
    }
    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);
    }
}

