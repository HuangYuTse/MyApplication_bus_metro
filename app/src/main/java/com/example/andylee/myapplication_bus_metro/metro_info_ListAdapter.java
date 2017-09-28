package com.example.andylee.myapplication_bus_metro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andylee on 2017/5/3.
 */

public class metro_info_ListAdapter extends BaseAdapter{

    private Context context;
    private List<metro_info> metro_infos_list;

    public metro_info_ListAdapter(Context context, List<metro_info> metro_infos_list) {
        this.context = context;
        this.metro_infos_list = metro_infos_list;
    }

    @Override
    public int getCount() {
        return metro_infos_list.size();
    }

    @Override
    public Object getItem(int position) {
        return metro_infos_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.listview_item_metro, null);
        TextView textView_id = (TextView) view.findViewById(R.id.id_number_metro);
        TextView textView_station_status = (TextView) view.findViewById(R.id.station_status_metro);
        TextView textView_destination = (TextView) view.findViewById(R.id.destination_metro);

        textView_id.setText(String.valueOf(metro_infos_list.get(position).getId()));
        textView_station_status.setText(metro_infos_list.get(position).getStation_name());
        textView_destination.setText(metro_infos_list.get(position).getDestination_name());

        view.setTag(metro_infos_list.get(position).getId());

        return view;
    }
}
