package com.team8.seatonvalley;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tomsturgeon on 30/03/2018.
 * Last Edited by tomsturgeon on 18/04/2018.
 *
 * InformationFragment contains information about seaton valley council including waste and opening times
 */

public class InformationFragment extends Fragment {

    private TextView link;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_information, container, false);
        link = v.findViewById(R.id.wasteManagementText);

        //on clicking the wasteManagementText textView, this will load a page to the correct place to find this information
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.northumberland.gov.uk/Waste.aspx";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Information");
    }

}
