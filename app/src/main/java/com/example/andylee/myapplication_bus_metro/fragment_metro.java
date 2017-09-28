package com.example.andylee.myapplication_bus_metro;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_metro extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private TextView testResult;
    private RadioButton radioButton01, radioButton02, radioButton03, radioButton04, radioButton05;
    //private SegmentedGroup segmentedGroup01;
    private TextView textViewcouting;
    //private JSONTask jsonTask;
    private CountDownTimer countDownTimer;
    private ProgressBar progressBar;
    private int counting_time_bar = 0;

    private ListView listView = null;
    private metro_info_ListAdapter adapter;
    private List<metro_info> metro_infos_list;
    private JSONTask jsonTask;
    private SegmentedGroup segmented;
    private TextView textViewtest;
    public int choose_line_number = 0;
    public Toast mToast;
    public int listthemenu = 0;
    public ImageView imageView;
    public TextView textviewaboutbegin;
    //**////**////**////**////**////**////**////**////**////**////**////**////**////**////**////**////**//
    public DBHelper helper;
    public SQLiteDatabase db;
    //**////**////**////**////**////**////**////**////**////**////**////**////**////**////**////**////**//
    public fragment_metro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_metro, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        startgetview();
        counting_time_bar = 0;
        setProgressBar();
        timersetting();
        countDownTimer.cancel();
        progressBar.setProgress(counting_time_bar);
        setHasOptionsMenu(true);
        getActivity().getFragmentManager().popBackStack();
        helper = new DBHelper(getActivity());
    }
    public void startgetview(){
        //testResult = (TextView) getView().findViewById(R.id.textView3);
        //testResult.setMovementMethod(ScrollingMovementMethod.getInstance());
        radioButton01 = (RadioButton) getView().findViewById(R.id.radio_button_ios01);
        radioButton02 = (RadioButton) getView().findViewById(R.id.radio_button_ios02);
        radioButton03 = (RadioButton) getView().findViewById(R.id.radio_button_ios03);
        radioButton04 = (RadioButton) getView().findViewById(R.id.radio_button_ios04);
        radioButton05 = (RadioButton) getView().findViewById(R.id.radio_button_ios05);
        //segmentedGroup01 = (SegmentedGroup) getView().getRootView().findViewById(R.id.segmented01);
        //segmentedGroup01.setTintColor(Color.BLUE);
        textViewcouting = (TextView) getView().findViewById(R.id.textView_counting_auto);
        progressBar = (ProgressBar) getView().findViewById(R.id.progressBar01);

        imageView = (ImageView) getView().findViewById(R.id.imageView);
        textviewaboutbegin = (TextView) getView().findViewById(R.id.textView2);
        listView = (ListView) getView().findViewById(R.id.listviewproduct);
        segmented = (SegmentedGroup) getView().getRootView().findViewById(R.id.segmented01);
        segmented.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_button_ios01:
                if (listthemenu == 0){
                    setProgressBar();
                    timersetting();
                    listthemenu = 1;
                    imageView.setVisibility(View.GONE);
                    textviewaboutbegin.setVisibility(View.GONE);
                }
                if (choose_line_number != 1){
                    choose_line_number = 1;
                    JSONinitialize();
                    showToast(getString(R.string.brown));
                    counting_time_bar = 0;
                    setProgressBar();
                    countDownTimer.cancel();
                }
                break;
            case R.id.radio_button_ios02:
                if (listthemenu == 0){
                    setProgressBar();
                    timersetting();
                    listthemenu = 1;
                    imageView.setVisibility(View.GONE);
                    textviewaboutbegin.setVisibility(View.GONE);
                }
                if (choose_line_number != 2){
                    choose_line_number = 2;
                    JSONinitialize();
                    showToast(getString(R.string.red));
                    counting_time_bar = 0;
                    setProgressBar();
                    countDownTimer.cancel();
                }
                break;
            case R.id.radio_button_ios03:
                if (listthemenu == 0){
                    setProgressBar();
                    timersetting();
                    listthemenu = 1;
                    imageView.setVisibility(View.GONE);
                    textviewaboutbegin.setVisibility(View.GONE);
                }
                if (choose_line_number != 3){
                    choose_line_number = 3;
                    JSONinitialize();
                    showToast(getString(R.string.green));
                    counting_time_bar = 0;
                    setProgressBar();
                    countDownTimer.cancel();
                }
                break;
            case R.id.radio_button_ios04:
                if (listthemenu == 0){
                    setProgressBar();
                    timersetting();
                    listthemenu = 1;
                    imageView.setVisibility(View.GONE);
                    textviewaboutbegin.setVisibility(View.GONE);
                }
                if (choose_line_number != 4){
                    choose_line_number = 4;
                    JSONinitialize();
                    showToast(getString(R.string.orange));
                    counting_time_bar = 0;
                    setProgressBar();
                    countDownTimer.cancel();
                }
                break;
            case R.id.radio_button_ios05:
                if (listthemenu == 0){
                    setProgressBar();
                    timersetting();
                    listthemenu = 1;
                    imageView.setVisibility(View.GONE);
                    textviewaboutbegin.setVisibility(View.GONE);
                }
                if (choose_line_number != 5){
                    choose_line_number = 5;
                    JSONinitialize();
                    showToast(getString(R.string.blue));
                    counting_time_bar = 0;
                    setProgressBar();
                    countDownTimer.cancel();
                }
                break;
            default:
                // Nothing to do
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.actionbar_fragment_metro, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(menuItem.getItemId() == R.id.actionbar_button_refresh){
            if (listthemenu == 1){
                JSONinitialize();
                showToast(getString(R.string.refreshing));
                counting_time_bar = 0;
                setProgressBar();
                countDownTimer.cancel();
            }else{
                showToast(getString(R.string.please_select_route));
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void JSONinitialize(){
        System.gc();
        jsonTask = new JSONTask();
        jsonTask.execute("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=55ec6d6e-dc5c-4268-a725-d04cc262172b");
    }

    public void timersetting(){
        countDownTimer = new CountDownTimer(30000, 1000){
            @Override
            public void onFinish() {
                JSONinitialize();
                counting_time_bar = 0;
                countDownTimer.cancel();
            }
            @Override
            public void onTick(long millisUntilFinished){
                textViewcouting.setText(getString(R.string.sec_remaining) + millisUntilFinished / 1000);
                counting_time_bar++;
                progressBar.setProgress(counting_time_bar);
            }
        }.start();
    }

    public void setProgressBar(){
        progressBar.setMax(30);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(1);
    }

    public void showToast(String string){
        if (mToast == null){
            mToast = Toast.makeText(getContext(), " ", Toast.LENGTH_SHORT);//
        }
        mToast.setText(string);
        mToast.show();
    }


    public class JSONTask extends AsyncTask<String, String, String> {
        private TextView textView;
        public ArrayList<Integer> arrayList_idnum;
        public ArrayList<String> arrayList_station_status;
        public ArrayList<String> arrayList_destination;
        public int total;
        public ArrayList<metro_info> metro_infos_list;
        public metro_info_ListAdapter adapter;

        public ProgressDialog dialog;
        public JSONTask() {
            dialog = new ProgressDialog(getContext());
        }
        protected void onPreExecute(){
            dialog.setMessage(getString(R.string.connecting));
            dialog.show();
            textViewcouting.setText(getString(R.string.refreshing));
        }
        @Override
        protected String doInBackground(String... params){
            metro_infos_list = new ArrayList<metro_info>();
            arrayList_idnum = new ArrayList<Integer>();
            arrayList_station_status = new ArrayList<String>();
            arrayList_destination = new ArrayList<String>();
            total = 0;
            arrayList_idnum.clear();
            arrayList_station_status.clear();
            arrayList_destination.clear();
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finalJson = buffer.toString();
                JSONObject parentObject01 = new JSONObject(finalJson);
                JSONObject parentObject02 = parentObject01.getJSONObject("result");
                JSONArray parentArray = parentObject02.getJSONArray("results");

                StringBuffer bufferfinal = new StringBuffer();
                total = parentArray.length();
                data dt = new data();
                helper.removeAll();
                for (int n = 0; n < parentArray.length(); n++){
                    JSONObject finalObject = parentArray.getJSONObject(n);
                    int id_num = finalObject.getInt("_id");
                    String station_name = finalObject.getString("Station");
                    String Destination_name = finalObject.getString("Destination");
                    dt.put_idnumber(id_num);
                    dt.put_station_status(station_name);
                    dt.put_destination(Destination_name);
                    helper.addsomething(dt);
                    String temp = String.valueOf(id_num);
                    bufferfinal.append(temp + " -- " + station_name + " -- " + Destination_name + "\n");
                }
                Log.d("getting...", "Reading all data");
                List<data> results = helper.getAlldatas();
                for (int n = 0; n < results.size(); n++){
                    int num = results.get(n).get_idnumber();
                    String station = results.get(n).get_station_status();
                    String destination = results.get(n).get_destination();
                    Log.d("results", num + " " + station + " " + destination);
                }
                return bufferfinal.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                connection.disconnect();
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            metro_infos_list = new ArrayList<metro_info>();
            List<data> results = helper.getAlldatas();
            for (int n = 0; n < results.size(); n++){
                int num = results.get(n).get_idnumber();
                String station = results.get(n).get_station_status();
                String destination = results.get(n).get_destination();
                arrayList_idnum.add(num);
                arrayList_station_status.add(station);
                arrayList_destination.add(destination);
            }
            if (choose_line_number == 1){
                for(int n = 0; n < total; n++){
                    if(arrayList_destination.get(n).equals("南港展覽館站") || arrayList_destination.get(n).equals("動物園站")){
                        metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));
                    }
                }
            }else if (choose_line_number == 2){
                for(int n = 0; n < total; n++){
                    if(arrayList_destination.get(n).equals("淡水站") || arrayList_destination.get(n).equals("象山站") || arrayList_destination.get(n).equals("北投站") || arrayList_destination.get(n).equals("大安站")){
                        metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));
                    }
                }
            }else if (choose_line_number == 3){
                for(int n = 0; n < total; n++){
                    if(arrayList_destination.get(n).equals("松山站") || arrayList_destination.get(n).equals("新店站") || arrayList_destination.get(n).equals("台電大樓站")){
                        metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));
                    }
                }
            }else if (choose_line_number == 4){
                for(int n = 0; n < total; n++){
                    if(arrayList_destination.get(n).equals("蘆洲站") || arrayList_destination.get(n).equals("迴龍站") || arrayList_destination.get(n).equals("南勢角站")){
                        metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));

                    }
                }
            }else if (choose_line_number == 5){
                for(int n = 0; n < total; n++){
                    if(arrayList_destination.get(n).equals("南港展覽館站") || arrayList_destination.get(n).equals("頂埔站") || arrayList_destination.get(n).equals("亞東醫院站")){
                        metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));
                    }
                }
            }else{
                for(int n = 0; n < total; n++){
                    metro_infos_list.add(new metro_info(arrayList_idnum.get(n), "進站：" + arrayList_station_status.get(n), arrayList_destination.get(n)));
                }
            }
            adapter = new metro_info_ListAdapter(getContext(), metro_infos_list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getContext(), "Clicked bar id =" + view.getTag(), Toast.LENGTH_SHORT).show();
                }
            });
            textViewcouting.setText(getString(R.string.updating));
            if (dialog.isShowing()){
                counting_time_bar = 0;
                if (arrayList_idnum.get(0) == null){
                    dialog.setMessage(getString(R.string.response));
                    countDownTimer.cancel();
                }
                countDownTimer.start();
                dialog.dismiss();
            }
            this.cancel(true);
        }
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if (jsonTask != null){
            jsonTask.cancel(true);
            countDownTimer.cancel();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        jsonTask.cancel(true);
        countDownTimer.cancel();
    }
    @Override
    public void onDetach(){
        super.onDetach();
        jsonTask.cancel(true);
        countDownTimer.cancel();
    }
}
