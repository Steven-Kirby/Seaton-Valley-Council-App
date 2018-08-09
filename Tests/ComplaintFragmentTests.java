package com.team8.seatonvalley;

import android.app.Instrumentation;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.team8.seatonvalley.ComplaintFragment;
import com.team8.seatonvalley.MainActivity;
import com.team8.seatonvalley.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

/*
Test for the complaint fragment
Written by Darren Lee
*/

public class ComplaintFragmentTests {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);



    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }


    /*Checks all views are initialised correctly*/
    @Test
    public void testComplaintFragmentLaunch() throws Exception {

        DrawerLayout rlContainer = mActivity.findViewById(R.id.drawer_layout);
        assertNotNull(rlContainer);

        ComplaintFragment complaintFragment = new ComplaintFragment();
        mActivity.getSupportFragmentManager().beginTransaction().add(complaintFragment, null).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();

        View view = complaintFragment.getView().findViewById(R.id.spinner);
        assertNotNull(view);

        view = complaintFragment.getView().findViewById(R.id.complaintBody);
        assertNotNull(view);

        view = complaintFragment.getView().findViewById(R.id.submitButton);
        assertNotNull(view);

        view = complaintFragment.getView().findViewById(R.id.nameEditText);
        assertNotNull(view);

        view = complaintFragment.getView().findViewById(R.id.emailEditText);
        assertNotNull(view);

        view = complaintFragment.getView().findViewById(R.id.reportLinkText);
        assertNotNull(view);

    }

    /*Checks all the spinner choices and checks that the correct views are displayed for each one*/
    @Test
    public void checkSpinnerChoicesViews(){

         String [] VALUES = {"Education", "Transport", "Planning", "Fire and Public Safety", "Social Care", "Libraries", "Waste Management",
                "Allotments", "Public Clocks", "Bus Shelters", "Community Centres", "Play Areas", "Grants", "Neighbourhood Planning", "Litter, Fouling and Graffiti"};

        String [] PARISH_ISSUES =
                {"Allotments", "Public Clocks", "Bus Shelters", "Community Centres", "Play Areas", "Grants", "Neighbourhood Planning", "Litter, Fouling and Graffiti"};

        DrawerLayout rlContainer = mActivity.findViewById(R.id.drawer_layout);
        ComplaintFragment complaintFragment = new ComplaintFragment();
        mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, complaintFragment).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();

        String str = null;
        for(int i = 0; i< 15 ; i++ ) {


            str = VALUES[i];
            onView(withId(R.id.spinner))
                    .perform(click());
            onData(hasToString(startsWith(str)))
                    .perform(click());
            if (Arrays.asList(PARISH_ISSUES).contains(str)) {

                assertTrue(complaintFragment.getView().findViewById(R.id.submitButton).isShown());
                assertTrue(complaintFragment.getView().findViewById(R.id.complaintBody).isShown());
                assertFalse(complaintFragment.getView().findViewById(R.id.reportLinkText).isShown());
            } else {
                assertFalse(complaintFragment.getView().findViewById(R.id.submitButton).isShown());
                assertFalse(complaintFragment.getView().findViewById(R.id.complaintBody).isShown());
                assertTrue(complaintFragment.getView().findViewById(R.id.reportLinkText).isShown());

            }
        }
    }



    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }


}