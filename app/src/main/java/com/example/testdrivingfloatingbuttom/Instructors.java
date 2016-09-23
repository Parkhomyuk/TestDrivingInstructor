package com.example.testdrivingfloatingbuttom;

import android.location.Address;


public class Instructors {
    String name;
    String city;
    int avatar;
    String age;
    String experience;
    String rating;
    String typeVehicle;

    public Instructors(String name, String city, int avatar, String age, String experience, String rating, String typeVehicle) {
        this.name = name;
        this.city = city;
        this.avatar = avatar;
        this.age=age;
        this.experience = experience;
        this.rating = rating;
        this.typeVehicle=typeVehicle;
    }

    public Instructors() {
    }
}
