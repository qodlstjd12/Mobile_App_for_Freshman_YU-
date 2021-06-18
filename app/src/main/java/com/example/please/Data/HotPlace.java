package com.example.please.Data;


import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public class HotPlace {
    LatLng location;
    double longitude;
    double latitude;
    String title;
    Location l1;
    String HP;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getTitle() {
        return title;
    }

    public Location getL1() {
        return l1;
    }

    public String getHP() {
        return HP;
    }



    public HotPlace(double longitude, double latitude, String title,String HP){
        this.location = new LatLng(longitude, latitude);
        this.l1 = new Location(title);
        this.HP = HP;
        l1.setLongitude(longitude);
        l1.setLatitude(latitude);
    }
    public Location getLocation(){
        return l1;
    }
    public LatLng getLatLng(){
        return location;
    }
}