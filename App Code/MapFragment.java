package com.team8.seatonvalley;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

/**
 * Created by tomsturgeon on 31/03/2018.
 * Last Edited by Steven Kirby on 21/04/2018.
 *
 * MapFragment is a google map showing events objects on it as markers as well as borders of the 3 areas of seaton valley council
 * clicking on a event will show the user the event they have clicked in more detail
 */

public class MapFragment extends Fragment {

    MapView mMapView;
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        //associate this view with xml view
        mMapView = v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        //get context of where map is
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //on a secondary thread, load the map, so the map doesnt hang the main or UI thread while loading
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                //first tries to use any arguments that may have been passed(can only be lat and long currently), if that fails,
                // it catches the exception and uses default lat long co-ords with a less zoomed in view.
                try {
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(45.00f).target(new LatLng(getArguments().getDouble("Lat"), getArguments().getDouble("Long"))).zoom(14.5f).build()));
                } catch (NullPointerException e) {
                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().tilt(45.00f).target(new LatLng(55.07196, -1.52609)).zoom(11.5f).build()));
                }

                //shows up to date information on how busy traffic is in an area
                mMap.setTrafficEnabled(true);
                if (SplashScreen.getEvents() != null) {
                    for (Event e : SplashScreen.getEvents()) {
                        LatLng place = new LatLng(e.latitude, e.longitude);
                        mMap.addMarker(new MarkerOptions().position(place).title(e.name).snippet("at " + e.location + " on " + e.dateTime));
                    }
                }
                //seaton delaval border
                mMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(55.099359, -1.566504))
                        .add(new LatLng(55.102911, -1.548911))
                        .add(new LatLng(55.100835, -1.542236))
                        .add(new LatLng(55.103488, -1.533304))
                        .add(new LatLng(55.096434, -1.529806))
                        .add(new LatLng(55.102676, -1.494991))
                        .add(new LatLng(55.084535, -1.473518))
                        .add(new LatLng(55.084001, -1.476811))
                        .add(new LatLng(55.079857, -1.479076))
                        .add(new LatLng(55.072422, -1.474202))
                        .add(new LatLng(55.065877, -1.492308))
                        .add(new LatLng(55.062005, -1.518137))
                        .add(new LatLng(55.068811, -1.551793))
                        .add(new LatLng(55.058154, -1.576988))
                        .add(new LatLng(55.076934, -1.570106))
                        .add(new LatLng(55.076821, -1.546737))
                        .add(new LatLng(55.083838, -1.567235))
                        .add(new LatLng(55.099359, -1.566504))
                        //0x - transparancy - red - green - blue
                        .strokeColor(0x3FFF0000))
                        .setFillColor(0x12FF0000);

                //seaton sluice border
                mMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(55.085116, -1.470099))
                        .add(new LatLng(55.083926, -1.476587))
                        .add(new LatLng(55.079887, -1.478996))
                        .add(new LatLng(55.072422, -1.474152))
                        .add(new LatLng(55.074566, -1.461181))
                        .add(new LatLng(55.085116, -1.470099))
                        //0x - transparancy - red - green - blue
                        .strokeColor(0x3F00FF00))
                        .setFillColor(0x1200FF00);


                //seghill border
                mMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(55.058059, -1.576891))
                        .add(new LatLng(55.068725, -1.550589))
                        .add(new LatLng(55.061915, -1.518184))
                        .add(new LatLng(55.065877, -1.492308))
                        .add(new LatLng(55.053956, -1.487244))
                        .add(new LatLng(55.048204, -1.508651))
                        .add(new LatLng(55.054891, -1.510239))
                        .add(new LatLng(55.054216, -1.532341))
                        .add(new LatLng(55.061501, -1.539828))
                        .add(new LatLng(55.054201, -1.556479))
                        .add(new LatLng(55.058059, -1.576891))
                        //0x - transparancy - red - green - blue
                        .strokeColor(0x3F0000FF))
                        .setFillColor(0x120000FF);

                //clicking on the information popup after clicking marker takes you to event page
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {

                        //need to get activity context from fragment transaction
                        MainActivity ma = (MainActivity) getView().getContext();
                        FragmentTransaction ft = ma.getSupportFragmentManager().beginTransaction();

                        //create a new events fragment to add a bundle of arguments to
                        EventsFragment eventFrag = new EventsFragment();
                        Bundle args = new Bundle();

                        //uses the clicked markers position on the map
                        args.putDouble("Lat", marker.getPosition().latitude);
                        args.putDouble("Long", marker.getPosition().longitude);
                        eventFrag.setArguments(args);
                        //adds to the back button push/pop stack
                        ft.addToBackStack("tag");
                        ft.replace(R.id.content_main, eventFrag).commit();
                    }
                });

                getPermission();
            }


            /**
             * Gets permission from user to get their location data, in case the user wants to know where they are on the map
             */
            public void getPermission() {

                //checks if permission already exists , if it does, set location to enabled
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    mMap.setMyLocationEnabled(true);

                    //if it doesn't, ask for it.
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);
                }

            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Map");
    }


}


