package com.example.contact_storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragement_Add_Contact extends Fragment {
   public Button save;
   public EditText MyName,MyPhoneNumber,MyEmail;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.add_contact,container,false);
        save=(Button) view.findViewById(R.id.button);
        MyName=(EditText) view.findViewById(R.id.editText);
        MyPhoneNumber=(EditText) view.findViewById(R.id.editText2);
        MyEmail=(EditText) view.findViewById(R.id.editText3);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name=MyName.getText().toString();
                String phone=MyPhoneNumber.getText().toString();
                String mail=MyEmail.getText().toString();

              DataAuthenication dataAuthenication=new DataAuthenication(name,phone,mail);
                 Boolean Na=dataAuthenication.getName();
                 Boolean PhoneNum=dataAuthenication.getphoneNumber();
                 Boolean Email=dataAuthenication.getEmail();

                   if(Na==false) {
                       Toast.makeText(getContext(), "fill First", Toast.LENGTH_LONG).show();
                   }
                else if(PhoneNum==false) {
                    Toast.makeText(getContext(), "fill First", Toast.LENGTH_LONG).show();
                }
                else if(Email==false) {
                    Toast.makeText(getContext(), "fill First", Toast.LENGTH_LONG).show();
                }
                   else{
                       Toast.makeText(getContext(), "Not Problem", Toast.LENGTH_LONG).show();
                       DBhelper dBhelper=new DBhelper(getContext());
                       SQLiteDatabase db=dBhelper.getWritableDatabase();
                       ContentValues values=new ContentValues();
                       values.put("name",name);
                       values.put("phonenumber",phone);
                       values.put("email",mail);
                       try {
                           db.insert("contactlist1", null, values);
                           Toast.makeText(getContext(),"Added SuccessFully",Toast.LENGTH_LONG).show();
                           MyName.setText("");
                           MyPhoneNumber.setText("");
                           MyEmail.setText("");
                       }catch (Exception e){Log.d("insertEror","NOt Inserted");}

                    // db =dBhelper.getReadableDatabase();
                     //Cursor cursor=db.rawQuery("select * from contactlist1",null);


                     /* if(cursor.getCount()==0){Log.d("data","No Data");}
                      else{
                           while (cursor.moveToNext()) {
                               Log.d("row","Row"+cursor.getString(0));


                           }
                       }

                       cursor.close();*/
                     /*String[] ab=dBhelper.readData(db);
                     Fragment fr=getFragmentManager().findFragmentById(R.id.viewPager);

                     String f=(String)fr.getTag();
                   ViewListAdapter viewListAdapter=new ViewListAdapter(getContext(),5,ab);
                   Fragement_Contact_List fragement_contact_list=(Fragement_Contact_List) getFragmentManager().findFragmentByTag(f);*/

                   }

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
