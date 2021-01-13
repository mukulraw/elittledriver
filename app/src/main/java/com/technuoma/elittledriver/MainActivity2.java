package com.technuoma.elittledriver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    Toolbar toolbar;

    ViewPager pager;

    TabLayout tabLayout;

    PagerAdapter adapter;

    ImageView logout;

    TextView cname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cname = findViewById(R.id.location);

        toolbar = findViewById(R.id.toolbar);


        logout = findViewById(R.id.logout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
*/
        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tablayout);

        String lname = SharePreferenceUtils.getInstance().getString("name");

        cname.setText(lname);

        adapter = new PagerAdapter(getSupportFragmentManager(), 2);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        //pager.setOffscreenPageLimit(3);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity2.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.logout_dialog);
                dialog.show();

                Button ookk = dialog.findViewById(R.id.button2);
                Button canc = dialog.findViewById(R.id.button4);

                canc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                ookk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        SharePreferenceUtils.getInstance().deletePref();

                        Intent intent = new Intent(MainActivity2.this, Splash.class);
                        startActivity(intent);

                        finishAffinity();

                    }
                });


            }
        });



    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        String[] titles = {
                "Pending Deliveries",
                "Completed Deliveries"
        };

        public PagerAdapter(FragmentManager fm, int list) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int i) {

            if (i == 0) {

                return new Bills3();
            }
            else
            {
                return new Bills4();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}