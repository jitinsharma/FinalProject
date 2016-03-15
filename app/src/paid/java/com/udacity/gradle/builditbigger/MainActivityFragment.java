package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sharma.jitin.jokedisplay.JokeActivity;


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
        Button jokeButton = (Button) root.findViewById(R.id.jokeBtn);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getActivity(), new EndpointsAsyncTaskListener());
                endpointsAsyncTask.execute();
            }
        });
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
