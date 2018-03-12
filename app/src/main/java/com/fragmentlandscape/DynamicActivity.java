package com.fragmentlandscape;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DynamicActivity extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        Intent i=getIntent();
        int h=i.getIntExtra("number",1);

        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        Fragment frag=new Fragment();

        if(h==1)
        {
            frag=new FragmentOne();
        }else
        if(h==2)
        {
            frag=new FragmentTwo();
        }else
        if(h==3)
        {
            frag=new FragmentThree();
        }
        Log.d("tag","inflated");
        ft.replace(R.id.menu,frag);
        ft.commit();
    }
}
