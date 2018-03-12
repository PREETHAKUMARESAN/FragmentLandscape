package com.fragmentlandscape;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orient= getScreenOrient();
                if(orient== Configuration.ORIENTATION_LANDSCAPE)
                    startLandscape(1);
                else
                    startPortrait(1);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orient= getScreenOrient();
                if(orient== Configuration.ORIENTATION_LANDSCAPE)
                    startLandscape(2);
                else
                    startPortrait(2);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orient= getScreenOrient();
                if(orient== Configuration.ORIENTATION_LANDSCAPE)
                    startLandscape(3);
                else
                    startPortrait(3);

            }
        });
    }

    public int getScreenOrient()
    {
        Display s= getWindowManager().getDefaultDisplay();
        int orient;

        if(s.getWidth() > s.getHeight())
            orient=Configuration.ORIENTATION_LANDSCAPE;
        else
            orient=Configuration.ORIENTATION_PORTRAIT;

        return orient;
    }

    public void startPortrait(int i)
    {
        Intent it=new Intent(MainActivity.this,DynamicActivity.class);
        it.putExtra("number",i);
        Log.d("tag","inflated");
        startActivity(it);
    }

    public void startLandscape(int i)
    {
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        Fragment frag= new Fragment();

        if(i==1) {
            frag = new FragmentOne();
        }
        if(i==2) {
            frag=new FragmentTwo();
        }
        if(i==3) {
            frag=new FragmentThree();
        }

        ft.replace(R.id.menu,frag);
        ft.commit();
    }
}
