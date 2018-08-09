package com.team8.seatonvalley;
/**
 * Created by Steven Kirby on 03/04/2018.
 * Last Edited by Steven Kirby on 06/04/2018.
 *
 * Person is an object containing information about a person and their picture for use in the ContactFragment
 */

class Person {

        String name;
        String number;
        int photo;
        String email;
        String description;

        Person(String name){
            this.name = name;
            this.email = "Email Not Available";
            this.number = "Number Not Available";
            this.photo = R.drawable.seatonheart;
            this.description = "Description Not Available";
        }

        Person(String name, String number){
        this.name = name;
        this.email = "Email Not Available";
        this.number = number;
        this.photo = R.drawable.seatonheart;
        this.description = "Description Not Available";
        }

        Person(String name, String number, int photo) {
            this.name = name;
            this.email = "Email Not Available";
            this.number = number;
            this.photo = photo;
            this.description = "Description Not Available";
        }

        Person(String name, String number, String email, int photo) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.photo = photo;
        this.description = "Description not available";
        }

        Person(String name, String number, String email, String description, int photo) {
            this.name = name;
            this.email = email;
            this.number = number;
            this.photo = photo;
            this.description = description;
        }

        Person(String name, String number, String email) {
            this.name = name;
            this.email = email;
            this.number = number;
            this.photo = R.drawable.seatonheart;
            this.description = "Description not available";
        }

        Person(String name, String number, String email, String description) {
            this.name = name;
            this.email = email;
            this.number = number;
            this.photo = R.drawable.seatonheart;
            this.description = description;
        }

        Person(int photo, String name, String email, String description) {
            this.name = name;
            this.email = email;
            this.number = "Number Not Available";
            this.photo = photo;
            this.description = description;
        }

        Person(int photo, String name, String email) {
            this.name = name;
            this.email = email;
            this.number = "Number Not Available";
            this.photo = photo;
            this.description = "Description Not Available";
        }



}