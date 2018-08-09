package com.team8.seatonvalley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tomsturgeon on 31/03/2018.
 * Last Edited by Steven Kirby on 09/04/
 *
 * ContactFragment allows the user to contact each council member from within the app by email or phone if available
 */

public class ContactFragment extends Fragment {

    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Contact Us");

        //Removes and adds cards onto a list view to help memory issues
        rv = view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeAdapter();
    }

    //adds the persons list to a list adapter to extract information and sets this to the recyclerview in XML
    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(SplashScreen.persons);
        rv.setAdapter(adapter);
    }




}
