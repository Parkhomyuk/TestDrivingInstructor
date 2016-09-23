package com.example.testdrivingfloatingbuttom;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Кирилл on 17.09.2016.
 */
public class MaterialDesignSignUpRegistrationFormXMLUI  extends AppCompatActivity {
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        final LinearLayout visLL=(LinearLayout)findViewById(R.id.contInstr);
        final RadioButton butStud=(RadioButton)findViewById(R.id.studentButton);
        final RadioButton butInst=(RadioButton)findViewById(R.id.instructorButton);
        radioGroup=(RadioGroup)findViewById(R.id.rbgroupStatus);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (radioButton != null && checkedId > -1) {
                    if(butInst.isChecked()){

                        visLL.setVisibility(View.VISIBLE);}
                    if(butStud.isChecked()){

                        visLL.setVisibility(View.GONE);}

                }
            }
        } );



    }
    public void onClear(View v){
radioGroup.clearCheck();
    }
}