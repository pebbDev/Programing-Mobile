package com.pebdev.layoutwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.pebdev.layoutwithfragment.adapter.ViewPagerAdapter;
import com.pebdev.layoutwithfragment.fragment.AccountFragment;
import com.pebdev.layoutwithfragment.fragment.ExploreFragment;
import com.pebdev.layoutwithfragment.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new HomeFragment(), "Home");
        adapter.AddFragment(new ExploreFragment(), "Explore");
        adapter.AddFragment(new AccountFragment(), "Account");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}