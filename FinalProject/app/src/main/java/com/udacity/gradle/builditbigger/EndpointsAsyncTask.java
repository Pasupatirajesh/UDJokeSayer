package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.android.javalib.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by SSubra27 on 11/13/17.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    MyApi myApiService = null;
    Context mContext;


    EndpointsAsyncTask(Context context)
    {
        this.mContext = context;

    }


    @Override
    protected String doInBackground(Pair<Context, String>[] pairs) {
        if(myApiService == null)
        {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://numeric-cinema-184003.appspot.com/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }
        mContext = pairs[0].first;

        try {
            return myApiService.sayJoke().execute().getJoke();
        } catch (IOException ioe)
        {
            return ioe.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        MainActivityFragment.mJokeString = s;

    }
}
