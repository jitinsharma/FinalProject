package com.udacity.gradle.builditbigger;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;

import com.google.android.gms.ads.InterstitialAd;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by jsharma on 15-Mar-16.
 */
public class TestAsyncFree {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testAsyncTask(){
        onView(withId(R.id.jokeBtn)).perform(click());
        SystemClock.sleep(8000);
        InterstitialAd interstitialAd = new InterstitialAd(mainActivityActivityTestRule.getActivity());
        if (interstitialAd != null){
            pressBack();
        }
        onView(withId(R.id.jokeDisplay)).check(matches(isDisplayed()));
        onView(withId(R.id.jokeDisplay)).check(matches(withText(containsString("is"))));
    }
}
