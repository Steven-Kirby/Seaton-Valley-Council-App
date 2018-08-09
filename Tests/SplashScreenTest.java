package com.team8.seatonvalleycouncil;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import com.team8.seatonvalley.MainActivity;
import com.team8.seatonvalley.SplashScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class SplashScreenTest {
    @Rule
    public ActivityTestRule<SplashScreen> msplashActivityTestRule = new ActivityTestRule<SplashScreen>(SplashScreen.class);
    private SplashScreen mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        mActivity = msplashActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        Activity mapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(mapActivity);
        mapActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
    }
}