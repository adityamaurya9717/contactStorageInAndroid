package com.example.contact_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity  {
   public FragementCollectionAdapter fragementCollectionAdapter;
   public TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout=(TabLayout) findViewById(R.id.tablayout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=(ViewPager) findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);


        fragementCollectionAdapter=new FragementCollectionAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(fragementCollectionAdapter);





        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==1){
                   Fragement_Contact_List fragement_contact_list=(Fragement_Contact_List) viewPager.getAdapter().instantiateItem(viewPager,position);
                      fragement_contact_list.onResume();
                    viewPager.getAdapter().notifyDataSetChanged();


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                finishAffinity();

        }


        return super.onOptionsItemSelected(item);
    }
}
