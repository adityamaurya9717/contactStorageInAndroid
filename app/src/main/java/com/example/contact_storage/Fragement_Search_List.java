package com.example.contact_storage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragement_Search_List extends Fragment {
      public SearchView searchView;
      public  ListView listView;
      public Fragement_Search_List(){

      }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.search_contact,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        searchView=(SearchView) view.findViewById(R.id.search_view);
        searchView.setQueryHint("Search Contact");
        listView=(ListView) view.findViewById(R.id.listview2);
        final DBhelper dBhelper=new DBhelper(getContext());
       final SQLiteDatabase db=dBhelper.getReadableDatabase();

        //String data[]={"apple","hello","abcd","applehello","abcd","apple","hello","abcd","apple","hello","abcd"};
        //final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,data);

       // listView.setAdapter(arrayAdapter);

        String searchdata[]=dBhelper.searchViewData(db,"a");

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,searchdata);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               String Text=newText;
               arrayAdapter.getFilter().filter(newText);


                return false;
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}

