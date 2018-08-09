package com.team8.seatonvalley;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void welcomeTextTest() {
        onView(withText("Welcome!")).check(matches(isDisplayed()));
    }

    @Test
    public void openNavBarTest() {
        onView(withId(R.id.drawer_layout)).perform(click());
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()));
    }
}