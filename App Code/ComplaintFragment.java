package com.team8.seatonvalley;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

/**
 * Created by tomsturgeon on 17/04/2018.
 * Last Edited by tomsturgeon on 20/04/2018.
 *
 * ComplaintFragment allows user to send an email regarding a complaint using predetermined issues,
 * and redirects them if needed to the correct authority
 */

public class ComplaintFragment extends Fragment {

private Button submitButton;
private String emailSubject;
private EditText clientName;
private EditText clientEmail;
private EditText emailBody;
private TextView reportChromeLink;
private Spinner spinner;

private final String [] VALUES = {"Education", "Transport", "Planning", "Fire and Public Safety", "Social Care", "Libraries", "Waste Management",
            "Allotments", "Public Clocks", "Bus Shelters", "Community Centres", "Play Areas", "Grants", "Neighbourhood Planning", "Litter, Fouling and Graffiti"};
private final String [] PARISH_ISSUES =
            {"Allotments", "Public Clocks", "Bus Shelters", "Community Centres", "Play Areas", "Grants", "Neighbourhood Planning", "Litter, Fouling and Graffiti"};

//TODO uncomment the real address and comment fake one
//private final String SEATON_VALLEY_PARISH_EMAIL = "clerk@seatonvalleycommunitycouncil.gov.uk";
private final String SEATON_VALLEY_PARISH_EMAIL = "seatonautomailer@gmail.com";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_complaint, container, false);


        //Initialise spinner
        spinner = v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, VALUES);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setSelection(7); // Corresponds to a parish council option so red text isnt shown straight away

        //Initialise elements
        emailBody = v.findViewById(R.id.complaintBody);
        submitButton = v.findViewById(R.id.submitButton);
        clientName = v.findViewById(R.id.nameEditText);
        clientEmail = v.findViewById(R.id.emailEditText);
        reportChromeLink = v.findViewById(R.id.reportLinkText);

        //Listeners
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                emailSubject = parent.getItemAtPosition(position).toString();
                if(Arrays.asList(PARISH_ISSUES).contains(emailSubject))
                {
                    //If parish issue, allow sending
                    submitButton.setVisibility(View.VISIBLE);
                    emailBody.setVisibility(View.VISIBLE);
                    reportChromeLink.setVisibility(View.GONE);
                }else{
                    //If community issue do not allow sending and give user a tooltip
                    submitButton.setVisibility(View.GONE);
                    emailBody.setVisibility(View.GONE);
                    reportChromeLink.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //onClickListener for community issues that opens browser
        reportChromeLink.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String url = "http://www.northumberland.gov.uk/SelfService/Report.aspx";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    //Send email on submit click
        submitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try {
                    //TODO uncomment this
                    new SimpleMail().sendEmail(SEATON_VALLEY_PARISH_EMAIL, emailSubject + " - " + clientName.getText().toString(), "From: " + clientEmail.getText() + "\n\n" + emailBody.getText().toString());
                    makeBlank();
                    Toast.makeText(getContext(), "Complaint sent successfully. Thank you.", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Make a Complaint");

    }

    public void makeBlank()
    {
        emailBody.setText("");
        clientEmail.setText("");
        clientName.setText("");
    }


}
