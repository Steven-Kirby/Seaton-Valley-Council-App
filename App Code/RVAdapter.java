package com.team8.seatonvalley;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
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
 * Last Edited by Steven Kirby on 06/04/2018.
 *
 * RVAdapter allows data to be passed into the cards of the listview/recyclerview for contact page
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personNumber;
        TextView personDescription;
        TextView personEmail;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);

            //associating textviews/imageview to corresponding XML views
            cv = itemView.findViewById(R.id.cv);
            personName = itemView.findViewById(R.id.person_name);
            personNumber = itemView.findViewById(R.id.person_number);
            personPhoto = itemView.findViewById(R.id.person_photo);
            personDescription = itemView.findViewById(R.id.person_description);
            personEmail = itemView.findViewById(R.id.person_email);

            //adding click listeners to phone number and email
            personNumber.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (!personNumber.getText().equals("Number Not Available")){

                        //opens new window with phone number added to it
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + personNumber.getText()));
                        v.getContext().startActivity(callIntent);
                    }
                }
            });
            personEmail.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (!personEmail.getText().equals("Email Not Available")){

                        //opens users choice of email client and adds email address to it
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                        emailIntent.setData(Uri.parse("mailto:" + personEmail.getText()));
                        v.getContext().startActivity(emailIntent);
                    }
                }
            });
        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        //setting the text of the textviews and image of imageview
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personNumber.setText(persons.get(i).number);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photo);
        personViewHolder.personDescription.setText(persons.get(i).description);

        //adding underlining and color to text to indicate it is clickable to user
        if (!personViewHolder.personNumber.getText().equals("Number Not Available")) {
            personViewHolder.personNumber.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
            personViewHolder.personNumber.setTextColor(personViewHolder.itemView.getContext().getResources().getColor(R.color.colorPrimary));
        }
        //as above
        personViewHolder.personEmail.setText(persons.get(i).email);
        if (!personViewHolder.personEmail.getText().equals("Email Not Available")) {
            personViewHolder.personEmail.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
            personViewHolder.personEmail.setTextColor(personViewHolder.itemView.getContext().getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}