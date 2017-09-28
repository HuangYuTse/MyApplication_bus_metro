package com.example.andylee.myapplication_bus_metro;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.lang.Runnable;

public class fragment_bus_result extends Fragment {
    String searchkey;
    Document doc,
            doc2;
    Thread th;
    Elements Content,
            Content2;
    String url;
    ExpandableTextView expTv1;
    String lol,
            lol1;
    RadioButton goBtn,
            backBtn;
    Handler handler;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_bus_result, container, false);
        searchkey = getArguments().getString("searckKey");
        url = "http://pda.5284.com.tw/MQS/businfo2.jsp?routename="+searchkey;

        return view;
    }
    public void startgetview(){
        handler =new Handler();
        expTv1 = (ExpandableTextView) getActivity().findViewById(R.id.expand_text_view)
                .findViewById(R.id.expand_text_view);
        goBtn = (RadioButton) getActivity().findViewById(R.id.goBtn);
        String goText = searchkey + "去程";
        goBtn.setText(goText);
        backBtn =(RadioButton) getActivity().findViewById(R.id.backBtn);
        String backText = searchkey + "回程";
        backBtn.setText(backText);
    }
    public void onclickbuttons(){
        goBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new Thread(goThread).start();
                Log.i("click","go");
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new Thread(backThread).start();
                Log.i("click","back");
            }
        });
    }
    public void onActivityCreated(Bundle saveInstanceState){
        startgetview();
        th=new Thread(goThread);                //執行緒
        th.start();
        onclickbuttons();
        super.onActivityCreated(saveInstanceState);
    }
    private Runnable goThread=new Runnable(){
        public void run(){
            try {
                doc = Jsoup.connect(url).get();        //連結該網址
                Content = doc.select("body > center > table:nth-child(3) > tbody > tr:nth-child(2) > td > table > tbody");
                Log.i("get",Content.text()+"\n");
                lol = "" ;
                int i = Content.select("tbody").get(1).select("tr").size();
                for (int l = 0; l < i; l++) {
                    lol = lol+Content.select("tbody").get(1).select("tr").get(l).text()+"\n";
                    Log.i("get", Content.select("tbody").get(1).select("tr").get(l).text()+"\n");
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        expTv1.setText(lol);
                    }
                });
            } catch (Exception e) {
                Log.i("err","連線失敗"+e.getMessage());
            }
        }
    };
    private Runnable backThread=new Runnable(){
        public void run(){
            try {
                doc2 = Jsoup.connect(url).get();        //連結該網址
                Content2 = doc.select("body > center > table:nth-child(3) > tbody > tr:nth-child(2) > td > table > tbody");
                Log.i("get",Content2.text()+"\n");
                lol1 = "" ;
                int j = Content2.select("tbody").get(2).select("tr").size();
                for (int l = 0; l < j; l++) {
                    lol1 = lol1+Content2.select("tbody").get(2).select("tr").get(l).text()+"\n";
                    Log.i("get", Content2.select("tbody").get(2).select("tr").get(l).text()+"\n");
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        expTv1.setText(lol1);
                    }
                });
            } catch (Exception e) {
                Log.i("err","連線失敗"+e.getMessage());
            }
        }
    };
}


