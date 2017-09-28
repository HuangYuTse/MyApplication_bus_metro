package com.example.andylee.myapplication_bus_metro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.beardedhen.androidbootstrap.BootstrapButton;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_bus extends Fragment{
    private Fragment nextFragment
            ,nextFragment2;//換頁宣告
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button button_red//按鈕宣告
            ,button_blue
            ,button_brown
            ,button_green
            ,button_orange
            ,button_fuck
            ,button_normal
            ,button_small
            ,button_highway
            ,button_low;
    Bundle bundle;
    public fragment_bus() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_bus, container, false);
    }
    private void setNextFragment(String bundle){
        this.transaction = manager.beginTransaction() ;
        this.nextFragment = new fragment_bus_result();
        this.bundle.putString("searckKey", bundle);
        this.nextFragment.setArguments(this.bundle);
        this.transaction.replace(R.id.content_layout,nextFragment);
        this.transaction.commit();
    }
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        manager= getActivity().getSupportFragmentManager() ;
        bundle = new Bundle();
        startgetview();
        onclickbuttons();
    }
    public void startgetview(){
        button_red = (Button) getView().findViewById(R.id.button21);
        button_blue = (Button) getView().findViewById(R.id.button22);
        button_brown = (Button) getView().findViewById(R.id.button23);
        button_green = (Button) getView().findViewById(R.id.button24);
        button_orange = (Button) getView().findViewById(R.id.button25);
        button_normal = (Button) getView().findViewById(R.id.button26);
        button_small = (Button) getView().findViewById(R.id.button27);
        button_fuck = (Button) getView().findViewById(R.id.button28);
        button_low = (Button) getView().findViewById(R.id.button29);
        button_highway = (Button) getView().findViewById(R.id.button30);
    }
    public void onclickbuttons(){
        button_red.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.redLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_blue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.blueLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_brown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.brownLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_green.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.greenLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_orange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.orangeLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_normal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.normalLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_small.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.smallLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_fuck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.fuckLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_low.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.lowLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
        button_highway.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new MaterialDialog.Builder(getActivity())
                        .items(R.array.highwayLine)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                Log.v("MaterialDialog",(String) text);
                                setNextFragment((String) text);
                            }
                        })
                        .show();
            }
        });
    }
}
