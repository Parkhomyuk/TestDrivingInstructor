package com.example.testdrivingfloatingbuttom;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Кирилл on 13.09.2016.
 */
public class OneFragment extends Fragment {
    public OneFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       /* // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);*/
        View v=inflater.inflate(R.layout.fragment_one,container,false);
        TextView tv=((TextView)v.findViewById(R.id.frVehc));
        tv.setText(getArguments().getString("text"));
        return v;
    }
}
