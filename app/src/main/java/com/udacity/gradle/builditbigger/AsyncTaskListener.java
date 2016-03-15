package com.udacity.gradle.builditbigger;

/**
 * Created by jsharma on 15-Mar-16.
 */
public interface AsyncTaskListener<T> {
    void onTaskComplete(T result);
}
