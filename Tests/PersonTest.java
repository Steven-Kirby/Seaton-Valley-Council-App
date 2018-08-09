package com.team8.seatonvalley;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void initialisePersons(){
        String name = "name";
        String number = "number";
        int photo = 1;
        String email = "email";
        String description = "description";

        Person person = new Person(name);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals("Number Not Available"));
        assertTrue(person.email.equals("Email Not Available"));
        assertTrue(person.photo == R.drawable.seatonheart);
        assertTrue(person.description.equals("Description Not Available"));

        person = new Person(name,number);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals(number));
        assertTrue(person.email.equals("Email Not Available"));
        assertTrue(person.photo == R.drawable.seatonheart);
        assertTrue(person.description.equals("Description Not Available"));

        person = new Person(name,number,photo);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals(number));
        assertTrue(person.email.equals("Email Not Available"));
        assertTrue(person.photo == photo);
        assertTrue(person.description.equals("Description Not Available"));

        person = new Person(name,number,email,description,photo);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals(number));
        assertTrue(person.email.equals(email));
        assertTrue(person.photo == photo);
        assertTrue(person.description.equals(description));


        person = new Person(name,number,email,description);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals(number));
        assertTrue(person.email.equals(email));
        assertTrue(person.photo == R.drawable.seatonheart);
        assertTrue(person.description.equals(description));


        person = new Person(photo,name,email,description);
        assertTrue(person.name.equals(name));
        assertTrue(person.number.equals("Number Not Available"));
        assertTrue(person.email.equals(email));
        assertTrue(person.photo == photo);
        assertTrue(person.description.equals(description));



    }

}