package com.example.contact_storage;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class Fragement_Contact_List extends Fragment {
   public ListView listView;
   public String[] data;
    private Object ContextMenu;
    String[] contactdataName;

    public Fragement_Contact_List(){

   }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.contact_list,container,false);

      // String data[]={"apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd","apple","hello","abcd"};
      //// ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(), R.layout.list_item_view,data);


       // viewListAdapter.notifyDataSetChanged();





        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        listView=(ListView) view.findViewById(R.id.listview);
        DBhelper dBhelper=new DBhelper(getContext());
         SQLiteDatabase db=dBhelper.getReadableDatabase();


         contactdataName= dBhelper.readData(db,0);
        String[] contactDataNumber=dBhelper.readData(db,1);

        setHasOptionsMenu(true);
         final ViewListAdapter viewListAdapter=new ViewListAdapter(getContext(),5,contactdataName,contactDataNumber);
        listView.setAdapter(viewListAdapter);
        viewListAdapter.notifyDataSetChanged();
        registerForContextMenu(listView);
        super.onViewCreated(view, savedInstanceState);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t=(TextView) view.findViewById(R.id.list);
                TextView t1=(TextView) view.findViewById(R.id.textView4);
                Object value=viewListAdapter.getItem(position);




                String abc=t1.getText().toString();

                //Toast.makeText(getContext(),""+abc,Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onCreateContextMenu(@NonNull android.view.ContextMenu menu, @NonNull View v, @Nullable android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
       MenuInflater menuInflater=getActivity().getMenuInflater();
       menuInflater.inflate(R.menu.popupmenu,menu);
        TextView t=(TextView) v.findViewById(R.id.list);

       AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuInfo;
       int p=info.position;
        String n=contactdataName[p];
       menu.setHeaderTitle("Select item"+info.position+n);


    }
}
