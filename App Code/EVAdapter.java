package com.team8.seatonvalley;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Steven Kirby on 04/04/2018.
 * Last Edited by Steven Kirby on 12/04/2018.
 *
 * EVAdapter allows data to be passed into the cards of the listview/recyclerview for contact page
 */

public class EVAdapter extends RecyclerView.Adapter<EVAdapter.EventViewHolder> {

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        CardView ev;
        TextView eventName;
        TextView eventLocation;
        TextView eventDateTime;
        TextView eventDescription;
        ImageView eventPicture;


        EventViewHolder(final View itemView) {
            super(itemView);

            //associating textviews/imageview to corresponding XML views
            ev = itemView.findViewById(R.id.ev);
            eventName = itemView.findViewById(R.id.event_name);
            eventLocation = itemView.findViewById(R.id.event_location);
            eventDateTime = itemView.findViewById(R.id.event_date_time);
            eventDescription = itemView.findViewById(R.id.event_description);
            eventPicture = itemView.findViewById(R.id.event_picture);

            //if clicking on the location of a event, it will take the user to the map location
            eventLocation.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (!eventLocation.getText().equals("TBA")){

                        //need to get the context of the main activity to use fragment transactions
                        MainActivity ma = (MainActivity) v.getContext();
                        FragmentTransaction ft = ma.getSupportFragmentManager().beginTransaction();

                        //create new fragment to add a bundle of arguments to
                        MapFragment mapFrag = new MapFragment();
                        Bundle args = new Bundle();

                        //adding latitude and longitude information as arguments to pass to the map fragment so it zooms to that location
                        if(!EventsFragment.getEvent().isEmpty()){
                            args.putDouble("Lat",EventsFragment.getEvent().get(0).latitude);
                            args.putDouble("Long",EventsFragment.getEvent().get(0).longitude);
                            //remove this so each time it is reset to an empty list
                            EventsFragment.getEvent().remove(0);
                        } else {
                            //adapterposition uses the index of the item in the list to get the correct information that has been clicked
                            args.putDouble("Lat", SplashScreen.getEvents().get(getAdapterPosition()).latitude);
                            args.putDouble("Long", SplashScreen.getEvents().get(getAdapterPosition()).longitude);
                        }
                        mapFrag.setArguments(args);
                        //backstack allows use of android back button
                        ft.addToBackStack("tag");
                        ft.replace(R.id.content_main,mapFrag).commit();
                    }
                }
            });
        }
    }

    List<Event> events;

    EVAdapter(List<Event> events) {
        this.events = events;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {

        //setting textview information and imageview information
        eventViewHolder.eventName.setText(events.get(i).name);
        eventViewHolder.eventLocation.setText(events.get(i).location);
        eventViewHolder.eventDateTime.setText(events.get(i).dateTime);
        eventViewHolder.eventDescription.setText(events.get(i).description);
        eventViewHolder.eventPicture.setImageResource(events.get(i).picture);

        //underlines location to prompt user to know its clickable
        eventViewHolder.eventLocation.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        eventViewHolder.eventLocation.setTextColor(eventViewHolder.itemView.getContext().getResources().getColor(R.color.colorPrimary));

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}