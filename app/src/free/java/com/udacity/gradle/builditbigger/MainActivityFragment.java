package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.sharma.jitin.jokedisplay.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button) root.findViewById(R.id.jokeBtn);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("DF0D3AC52B2F4EED5A482B488CBD2111")
                .build();
        mAdView.loadAd(adRequest);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), joke.getJoke(), Toast.LENGTH_SHORT).show();
                //EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getActivity(), new EndpointsAsyncTaskListener());
                //endpointsAsyncTask.execute(new Pair<Context, String>(getActivity(), "Manfred"));
                // Create the InterstitialAd and set the adUnitId.
                mInterstitialAd = new InterstitialAd(getActivity());
                // Defined in res/values/strings.xml
                mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        mInterstitialAd.show();
                    }

                    @Override
                    public void onAdClosed() {
                        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getActivity(), new EndpointsAsyncTaskListener());
                        endpointsAsyncTask.execute();
                    }
                });
                mInterstitialAd.loadAd(adRequest);
            }
        });
        //new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));
        return root;
    }

    class EndpointsAsyncTaskListener implements AsyncTaskListener<String> {

        @Override
        public void onTaskComplete(String result) {
            Intent intent = new Intent(getContext(), JokeActivity.class);
            intent.putExtra("joke", result);
            startActivity(intent);
        }
    }
}
