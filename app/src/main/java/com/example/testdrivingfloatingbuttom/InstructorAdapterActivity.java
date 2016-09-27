package com.example.testdrivingfloatingbuttom;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InstructorAdapterActivity extends Activity  implements AdapterView.OnItemClickListener{

    ArrayList<Instructors> insts = new ArrayList<Instructors>();
    BoxAdapter boxAdapter;
    Intent intent;
    TextView name;
    TextView city;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        //  To avoiding a matter  we change the fade color to transperant
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        assert slidingPaneLayout != null;
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);



        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, insts);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.instVar);
        lvMain.setOnItemClickListener(this);

        lvMain.setAdapter(boxAdapter);






    }


    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 3; i++) {
            insts.add(new Instructors("Instructor "+i, " city "+i+"city",R.drawable.christophe,i*12+" year",i*2+" year",i*56+" *****","A B C D"));
        }
        insts.add(new Instructors("Angelina Jolie","Tel Aviv",R.drawable.angela," 40 year","12 year"," 84","A B"));
        insts.add(new Instructors("Tom Zat","Netania",R.drawable.z," 27 year","4 year"," 42","A B C"));
        insts.add(new Instructors("Bruce Willis","Netania",R.drawable.bruce," 52 year","15 year"," 26","A B C D"));
        insts.add(new Instructors("Zipora Zukerman","Irusalim",R.drawable.savta," 60 year","27 year"," 17","A B "));
        insts.add(new Instructors("Tom Cruze","Irusalim",R.drawable.tom," 50 year","17 year"," 85","A B C D"));
        insts.add(new Instructors("Bill Geist","Tel Aviv",R.drawable.bill," 62 year","22 year"," 48","A B C D"));
        insts.add(new Instructors("Rostik Shahar","Haifa",R.drawable.toto," 27 year","4 year"," 12","B"));
        insts.add(new Instructors("Barack Abama","Haifa",R.drawable.barack," 55 year","20 year"," 44","A B"));
        insts.add(new Instructors("Jastin Timberlake","Rehovot",R.drawable.tim," 35 year","11 year"," 48","A B C"));
        insts.add(new Instructors("Brad Pit","Rehovot",R.drawable.brad," 45 year","18 year"," 68","A B C D"));
        insts.add(new Instructors("Haim Kaz","Netania",R.drawable.buch," 52 year","25 year"," 55","C D"));
        insts.add(new Instructors("Rafik Golubian","Tel Aviv",R.drawable.daty," 34 year","8 year"," 24","A C D"));
        insts.add(new Instructors("Lusy Zack","Tel Aviv",R.drawable.lucy," 24 year","1 year"," 24","A B"));
        insts.add(new Instructors("Jack Nicolson","Tel Aviv",R.drawable.nicola," 62 year","28 year"," 88","A B C D"));
        insts.add(new Instructors("Yosy Ferdman","Ashdod",R.drawable.saba," 74 year","35 year"," 98","A B C D"));
        insts.add(new Instructors("Rohel Bell","Ashkelon",R.drawable.savta," 64 year","15 year"," 55","A B"));
        insts.add(new Instructors("David Zukerman","Ashdod",R.drawable.saba2," 88 year","55 year"," 102","A B C D"));
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Instructors instructors=insts.get(position);
        /*Toast.makeText(this, instructors.toString(), Toast.LENGTH_LONG).show();*/
        intent= new Intent(InstructorAdapterActivity.this, TabInstructorActivity.class);
        /*name=(TextView)findViewById(R.id.tvName);*/
        String n=instructors.name;
        /*city=(TextView)findViewById(R.id.tvCity);*/
        String c=instructors.city;
        String e=instructors.experience;
        String r=instructors.rating;
        String a=instructors.age;
        int image=instructors.avatar;

        intent.putExtra("name",n);
        intent.putExtra("city",c);
        intent.putExtra("exper",e);
        intent.putExtra("rating",r);
        intent.putExtra("age",a);
        intent.putExtra("avatar",image);


        startActivity(intent);
    }

}