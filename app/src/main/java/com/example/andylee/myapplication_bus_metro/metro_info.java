package com.example.andylee.myapplication_bus_metro;

/**
 * Created by andylee on 2017/5/3.
 */

public class metro_info {
    private int id;
    private String station_name;
    private String destination_name;

    public metro_info(int id, String station_name, String destination_name) {
        this.id = id;
        this.station_name = station_name;
        this.destination_name = destination_name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }
}
