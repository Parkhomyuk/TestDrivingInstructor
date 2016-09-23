package com.example.testdrivingfloatingbuttom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кирилл on 20.09.2016.
 */
public class TabInstructorActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String textActivityVich;
    private String textActivityMe;
    private String textActivityRev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_instructor);
        String txtName=getIntent().getStringExtra("name");
        String txtCity=getIntent().getStringExtra("city");
        String txtExp=getIntent().getStringExtra("exper");
        String txtRat=getIntent().getStringExtra("rating");
        String txtAge=getIntent().getStringExtra("age");

        int image=getIntent().getIntExtra("avatar",0);
      TextView name=(TextView)findViewById(R.id.atName);
        name.setText(txtName);
      TextView city =(TextView)findViewById(R.id.atCity);
        city.setText(txtCity);
      TextView exper =(TextView)findViewById(R.id.atExp);
        exper.setText(txtExp);
      TextView rating =(TextView)findViewById(R.id.atRat);
        rating.setText(txtRat);
      TextView age=(TextView)findViewById(R.id.atAge);
        age.setText(txtAge);
        ImageView av=(ImageView) findViewById(R.id.im);
        av.setImageResource(image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textActivityVich=txtName;
        textActivityMe="I think that the best thing to do is go to a rally school. You can waste a lot of time and money by driving cars around not knowing what you’re doing. The best way to start is to let someone who has the experience teach you how to do it. I’ve been to several rally schools, the main one being Team O’Neil in the States. That was the first place I ever went and I got a lot of knowledge out of them. Travis Pastrana had gone there and I thought it looked fun, so I wanted to try and drive a rally car. I absolutely loved it but also found that I had a pretty decent amount of talent inside the car and since then I’ve just been pushing to learn more and more. Well the main thing is that I absolutely doing all this stuff. So the idea of me being able to get in a car and be able to drive all these courses at a demo is just for fun. But at a competition, like X Games or WRC, the competitive side takes over and I just want to win.";
        textActivityRev="No comments yet";
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabTabInstr);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Fragment ONE of TableInstructor
        Bundle bundle1 = new Bundle();
        bundle1.putString("text", textActivityVich);
        OneFragment fragmentOne = new OneFragment();
        fragmentOne.setArguments(bundle1);
        //Fragment TWO of TableInstructor
        Bundle bundle2= new Bundle();
        bundle2.putString("text1",textActivityMe);
        TwoFragmet fragmentTwo= new TwoFragmet();
        fragmentTwo.setArguments(bundle2);
        //Fragment THREE of TableInstructor
        Bundle bundle3 = new Bundle();
        bundle3.putString("text3", textActivityRev);
        ThreeFragment fragmentThree = new ThreeFragment();
        fragmentThree.setArguments(bundle3);

        adapter.addFragment(fragmentOne, "VEHICLE");
        adapter.addFragment(fragmentTwo, "ABOUT ME");
        adapter.addFragment(fragmentThree, "REVIEWS");

        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    private String createTabTypeVehicle(ArrayList<String> typeVehicle,ArrayList<String> typeTransmission) {
        /*String orderSummaryMsg = name;
        orderSummaryMsg +="\nAdd whipped cream? "+cream;
        orderSummaryMsg +="\nAdd chocolate? "+chokolate;
        orderSummaryMsg += "\nQuantity: " + mQuantity;
        orderSummaryMsg += "\nTotal: " + NumberFormat.getCurrencyInstance().format(price);
        orderSummaryMsg += "\nThank you!";*/
        return null;
    }
}

