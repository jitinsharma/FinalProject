package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        Button jokeButton = (Button)root.findViewById(R.id.jokeBtn);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("DF0D3AC52B2F4EED5A482B488CBD2111")
                .build();
        mAdView.loadAd(adRequest);

        /*jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), joke.getJoke(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), JokeActivity.class);
                intent.putExtra("joke", joke.getJoke());
                startActivity(intent);
            }
        });*/
        new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred"));
        return root;
    }
}
