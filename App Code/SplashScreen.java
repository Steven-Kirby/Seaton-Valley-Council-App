package com.team8.seatonvalley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven Kirby on 04/04/2018.
 * Last Edited by Steven Kirby on 15/04/2018.
 * TODO Add more real people and events
 *
 * SplashScreen displays for the required amount of time to load the app rather then having a blank screen.
 */

public class SplashScreen extends AppCompatActivity {

    public static List<Event> events;
    public static List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize data
        initializeEvents();
        initializePeople();

        //Go to new Activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Get the events list for adding events to the map
    public static List<Event> getEvents(){
        return events;
    }

    //Add data to static List of events
    public void initializeEvents(){
        events = new ArrayList<>();
        events.add(new Event("The Maintenance Man", "Community Centre",55.06875,-1.52046 , R.drawable.maintenance_man,"The Valley Players are doing a production of The Maintenance Man, a comedy drama by Richard Harris."));
        events.add(new Event("Full Council Meeting","15th April 2018, 7pm", "Seaton Valley Council Offices",55.073095,-1.526686 , R.drawable.full_council,"Interesting Council business things."));
        events.add(new Event("Youth Club","Every Tuesday, 6.30-8.30pm", "Astley High School, Seaton Delaval",55.0694274,-1.5242608 , R.drawable.youth_club,"The Council also works in partnership with Northumberland County Council Youth Service to provide activities for young people"));
        events.add(new Event("Youth Club","Every Wednesday, 6.30-8.30pm", "Seaton Sluice Community Centre",55.0822191,-1.4741897 , R.drawable.youth_club,"The Council also works in partnership with Northumberland County Council Youth Service to provide activities for young people"));
        events.add(new Event("Youth Club","Every Thursday, 6.30-8.30pm", "Seghill Institute Community Centre",55.063181,-1.5535146 , R.drawable.youth_club,"The Council also works in partnership with Northumberland County Council Youth Service to provide activities for young people"));


    }

    //Add data to static List of people
    private void initializePeople(){
        persons = new ArrayList<>();
        persons.add(new Person(R.drawable.simon_potts,"Simon Potts", "clerk@seatonvalleycommunitycouncil.gov.uk", "Clerk and Responsible Financial Officer"));
        persons.add(new Person(R.drawable.david_freeman,"David Freeman", "engagement@seatonvalleycommunitycouncil.gov.uk", "Engagement & Development Officer"));
        persons.add(new Person(R.drawable.lorraine_fox, "Lorraine Fox","services@seatonvalleycommunitycouncil.gov.uk","Services Officer"));
        persons.add(new Person(R.drawable.barbara_adams,"Barbara Adams","admin@seatonvalleycommunitycouncil.gov.uk","Administrator"));
        persons.add(new Person(R.drawable.neil_cairns,"Neil Cairns","neil@seatonvalleycommunitycouncil.gov.uk","Allotments & General Maintenance"));
        persons.add(new Person("Stephen Stanners", "07892 696394", "stephenstanners@hotmail.co.uk", "Chair (Seghill with Seaton Delaval)",R.drawable.stephen_stanners));
        persons.add(new Person("Barbara Burt", "0191 237 2712", "barbaraburt42@gmail.com", "Vice Chair (Hartley)",R.drawable.barbara_burt));
        persons.add(new Person("Karen Collier", "0191 237 0954", "k.collier714@btinternet.com", "Councillor (Hartley)",R.drawable.karen_collier));
        persons.add(new Person("Susan Dungworth", "0191 237 5531", "susan.dungworth@northumberland.gov.uk","Councillor (Hartley)", R.drawable.susan_dungworth));
        persons.add(new Person("Les Bowman", "0191 237 7032","lesbowman@me.com", "Councillor (Holywell)", R.drawable.les_bowman));
        persons.add(new Person("Eva Coulson", "07548 252042", "evacoulson@hotmail.co.uk","Councillor (Holywell)", R.drawable.eva_coulson));
        persons.add(new Person("Ann Stanners","07576 431152","annstanners@hotmail.com","Councillor (Holywell)",R.drawable.ann_stanners));
        persons.add(new Person("Simon Hartland","07709 681772","simonhartland@hotmail.co.uk","Councillor (Seghill with Seaton Delaval)",R.drawable.simon_hartland));
        persons.add(new Person("Daniel Nesbitt","07432 137980","danielnez1@gmail.com","Councillor (Seghill with Seaton Delaval)",R.drawable.daniel_nesbitt));

    }
}
