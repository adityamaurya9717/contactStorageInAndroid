package com.example.contact_storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import static java.security.AccessController.getContext;

public class FragementCollectionAdapter extends FragmentStatePagerAdapter {
     int tabCount;


     private String[] tabtitles=new String[]{"Add Contact","Contact List","Search"};
    public FragementCollectionAdapter(FragmentManager fm,int tabcount){
        super(fm);
        this.tabCount=tabcount;



    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }


    @Override
    public int getItemPosition(@NonNull Object object) {

        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

             if(position==0){
                    Fragement_Add_Contact fragement_add_contact=new Fragement_Add_Contact();
                     return fragement_add_contact;
               }

        else if(position==1){


                    Fragement_Contact_List fragement_contact_list=new Fragement_Contact_List();

                      return fragement_contact_list;

                     }


            else{
                Fragement_Search_List fragement_search_list=new Fragement_Search_List();
                return  fragement_search_list;

             }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
