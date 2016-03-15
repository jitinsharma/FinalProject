package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.sharma.jitin.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by jsharma on 15-Mar-16.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    ProgressDialog progressDialog;
    public AsyncTaskListener<String> asyncTaskListener;

    public EndpointsAsyncTask(Context context, AsyncTaskListener<String> asyncTaskListener){
        this.context = context;
        this.asyncTaskListener = asyncTaskListener;
    }

    @Override
    protected void onPreExecute(){
        progressDialog = ProgressDialog.show(context, context.getString(R.string.loading), context.getString(R.string.loading_below));
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1251.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        /*context = params[0].first;
        String name = params[0].second;*/

        try {
            //return myApiService.sayHi(name).execute().getData();
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        asyncTaskListener.onTaskComplete(result);
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        super.onPostExecute(result);
    }
}