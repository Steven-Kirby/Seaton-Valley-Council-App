package com.team8.seatonvalley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tomsturgeon on 30/03/2018.
 * Last Edited by Steven Kirby on 12/04/2018.
 *
 * EventsFragment is used to display all the events that are available
 */

public class EventsFragment extends Fragment {

    private RecyclerView erv;
    public static List<Event> event = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Events");


        erv= view.findViewById(R.id.erv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        erv.setLayoutManager(llm);
        erv.setHasFixedSize(true);

        initializeAdapter();
}

    /**
     * InitializeAdapter adds events to the recyclerview
     */
    private void initializeAdapter(){
       try{
           //for each event in all events loaded at start of app
           for (Event e : SplashScreen.getEvents()){
               //checks if firstly any arguments were passed (from clicking map event) and if it does it checks to see id the Lat and Long
               //are the same , and adds it to a new list.
               if (e.longitude == getArguments().getDouble("Long") && e.latitude == getArguments().getDouble("Lat")){
                   event.add(e);
               }
           }
           //adds this new list to the adapter to display the information
           EVAdapter adapter = new EVAdapter(event);
           erv.setAdapter(adapter);

       //if there were not any arguments a nullpointer will be thrown, in which case its safe to assume we have opened the fragment from the menu
       }catch(NullPointerException e) {
           //so adds the static list to the adapter to display all the events.
           EVAdapter adapter = new EVAdapter(SplashScreen.getEvents());
           erv.setAdapter(adapter);
       }


    }

    public static List<Event> getEvent(){
       return event;
    }

    //DATA FOR EVENTS IN SPLASHSCREEN
}
