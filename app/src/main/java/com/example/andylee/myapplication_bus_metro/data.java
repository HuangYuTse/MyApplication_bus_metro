package com.example.andylee.myapplication_bus_metro;

/**
 * Created by andylee on 2017/5/30.
 */

public class data {
    public int _idnumber;
    public String _station_status;
    public String _destination;
    public data() {

    }
    public void put_idnumber(int _idnumber){
        this._idnumber = _idnumber;
    }
    public void put_station_status(String _station_status){
        this._station_status = _station_status;
    }
    public void put_destination(String _destination){
        this._destination = _destination;
    }
    public int get_idnumber(){
        return _idnumber;
    }
    public String get_station_status(){
        return _station_status;
    }
    public String get_destination(){
        return _destination;
    }
}
