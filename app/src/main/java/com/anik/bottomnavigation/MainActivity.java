package com.anik.bottomnavigation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            //declare fragment
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //handle operation or what you want to do
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_dashboard:
                    //handle operation or what you want to do
                    fragment = new DashBoardFragment();
                    break;

                case R.id.navigation_notifications:

                    fragment = new NotificationFragment();
                    break;

                case R.id.navigation_inbox:
                    //handle operation or what you want to do

                    fragment = new InboxFragment();

                    break;

                case R.id.navigation_profile:
                    //handle operation or what you want to do

                    fragment = new ProfileFragment();
                    break;
            }

            return loadFragment(fragment); //call load fragment function
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    //loadFragment function
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
