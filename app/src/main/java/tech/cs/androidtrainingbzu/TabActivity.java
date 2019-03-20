package tech.cs.androidtrainingbzu;

import android.graphics.Bitmap;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import tech.cs.androidtrainingbzu.fragments.EduInfo_fragment;
import tech.cs.androidtrainingbzu.fragments.Pic_fragment;
import tech.cs.androidtrainingbzu.fragments.UserInfo_fragmwnt;

public class TabActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getIntent().getExtras());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("", null).show();


            }
        });

        // Bundle extras = getIntent().getExtras();
//            Pic_fragment pic = new Pic_fragment();
//            EduInfo_fragment ed= new EduInfo_fragment();
//            UserInfo_fragmwnt us = new UserInfo_fragmwnt();
//
//            pic.setArguments(extras);
//            ed.setArguments(extras);
//            us.setArguments(extras);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        Bundle extras = getIntent().getExtras();
//        String names = extras.getString("name");
//        Bitmap bitmap = extras.getParcelable(HW2.MSG1);
//        Pic_fragment pic = new Pic_fragment();
//        pic.imageView3.setImageBitmap(bitmap);


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        Bundle extras;
        public SectionsPagerAdapter(FragmentManager fm, Bundle extras) {
            super(fm);
            this.extras=extras;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            Bitmap bb = extras.getParcelable(HW2.MSG1);
            switch (position) {

                case 0:
                    fragment = new Pic_fragment();
                    fragment.setArguments(extras);
                    break;
                case 1:
                    fragment = new UserInfo_fragmwnt();
                    fragment.setArguments(extras);

                    break;
                case 2:
                    fragment = new EduInfo_fragment();
                    fragment.setArguments(extras);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Picture";
                case 1:
                    return "User Information";
                case 2:
                    return "Edu Information";
            }
            return null;
        }
    }
}
