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
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InstructorAdapterActivity extends Activity  implements AdapterView.OnItemClickListener{

    ArrayList<Instructors> insts = new ArrayList<Instructors>();
    BoxAdapter boxAdapter;
    Intent intent;
    private String[] mGroupsArray = new String[] { "City", "Type Vechile", "Tramsmission", "Experience","Rating" ,"Sex","Religious"};

    private String[] mVechicleArray = new String[] { "A", "B", "C" ,"D"};
    private String[] mTransmissionArray = new String[] { "Automatic", "Manual" };
    private String[] mExperienceArray = new String[] { "1-4", "5-8", "9-12","13 >" };
    private String[] mRatingArray = new String[] { "0-19", "20-39", "40-59","60-99","100 >" };
    private String[] mSexArray = new String[] { "no matter", "Man", "Woman" };
    private String[] mReligArray = new String[] { "no matter", "Yes", "No" };
    ArrayList<String> mCityArray1;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        //  To avoiding a matter  we change the fade color to transperant
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        assert slidingPaneLayout != null;
        slidingPaneLayout.setSliderFadeColor(Color.TRANSPARENT);

        fillData();
        mCityArray1= new ArrayList<>();
        for(int i=0;i<insts.size();i++){
            if(mCityArray1.contains(insts.get(i).getCity()))i++;
            else
            mCityArray1.add(insts.get(i).getCity());
        }
        //Filters in sliding left menu
        //------------ExpandbleListView City, Vechicle,Transsmission,Experrience,Rating--------------------
        Map<String, String> map;
        final ArrayList<Map<String,String>> groupDataList=new ArrayList<>();
        //complete the collection of groups from the array with the names of groups
        for(String group: mGroupsArray){
            map=new HashMap<>();
            map.put("groupName",group);
            groupDataList.add(map);
        }
        // a list of attribute groups to read
        String groupFrom[] = new String[] { "groupName" };
        // list ID view-elements, which will be placed groups attributes
        int groupTo[] = new int[] { android.R.id.text1 };
        //Create a shared collection of items for collections
        final ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();
        // create a collection of items for the City group
        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        // fill the list of attributes for each element
        for (String city : mCityArray1) {
            map = new HashMap<>();
            map.put("name", city); // name of city
            сhildDataItemList.add(map);
        }
        // add to the collection of collections
        сhildDataList.add(сhildDataItemList);

        //create a collection of items for the vechile
        сhildDataItemList=new ArrayList<>();
        for(String vichele: mVechicleArray){
            map=new HashMap<>();
            map.put("name",vichele);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        //create a collection of items for the Transmission
        сhildDataItemList=new ArrayList<>();
        for(String transmission: mTransmissionArray ){
            map=new HashMap<>();
            map.put("name",transmission);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        //create a collection of items for the Experiences
        сhildDataItemList=new ArrayList<>();
        for(String exper: mExperienceArray  ){
            map=new HashMap<>();
            map.put("name",exper);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        //create a collection of items for the Ratings
        сhildDataItemList=new ArrayList<>();
        for(String rating: mRatingArray  ){
            map=new HashMap<>();
            map.put("name",rating);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        //create a collection of items for the Sex
        сhildDataItemList=new ArrayList<>();
        for(String sex:  mSexArray ){
            map=new HashMap<>();
            map.put("name",sex);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        //create a collection of items for the Religion
        сhildDataItemList=new ArrayList<>();
        for(String relig:  mReligArray ){
            map=new HashMap<>();
            map.put("name",relig);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);
        // a list of attribute elements to read
        String childFrom[] = new String[] { "name" };

        // list ID view-elements, which will be placed attributes elements

        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.listViewFilter);
        expandableListView.setAdapter(adapter);
        //Filter listner
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){


            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(),
                        groupDataList.get(groupPosition)
                                + " : " +"Vau "+сhildDataList.get(groupPosition).get(childPosition),Toast.LENGTH_LONG).show();

                return false;
            }
        });






        //------------ExpandbleListView City, Vechicle,Transsmission,Experrience,Rating--------------------
        //Spinner Sex
        /*Spinner spinner= (Spinner) findViewById(R.id.spinnerSex);
        ArrayAdapter<?> adapterFilter=ArrayAdapter.createFromResource(this,R.array.sex,android.R.layout.simple_spinner_item);
        adapterFilter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterFilter);*/
        // create adapter for main view

        boxAdapter = new BoxAdapter(this, insts);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.instVar);
        lvMain.setOnItemClickListener(this);

        lvMain.setAdapter(boxAdapter);


    }


    // генерируем данные для адаптера
    void fillData() {

        insts.add(new Instructors("Dodik Moshe", "Tel Aviv",R.drawable.christophe," 24 year","2 year","24","A"));
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


    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id){
        return true;
    }

}