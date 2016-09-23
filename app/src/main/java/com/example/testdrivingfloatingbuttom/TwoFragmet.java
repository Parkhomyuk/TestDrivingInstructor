package com.example.testdrivingfloatingbuttom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Кирилл on 13.09.2016.
 */
public class TwoFragmet extends Fragment {

    public TwoFragmet() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* return inflater.inflate(R.layout.fragment_two, container, false);*/

        View v=inflater.inflate(R.layout.fragment_two,container,false);
        TextView tv=((TextView)v.findViewById(R.id.frMe));
        tv.setText(getArguments().getString("text1"));
        return v;
    }
}
