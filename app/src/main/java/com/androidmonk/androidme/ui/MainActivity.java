package com.androidmonk.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.androidmonk.androidme.R;
import com.androidmonk.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            //Head BodyPart Fragment
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setmImageIds(AndroidImageAssets.getHeads());


            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setmListIndex(headIndex);
            //Fragment to head container
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();


            //Fragment to body container
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setmListIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();


            //Fragment to leg container
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setmImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setmListIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
