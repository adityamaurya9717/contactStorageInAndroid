package com.example.contact_storage;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ViewListAdapter extends ArrayAdapter{
   Context context;
   String data[];
   String phone[];

    public ViewListAdapter(@NonNull Context context, int resource,String data[],String[] phonenumber) {
        super(context, R.layout.list_item_view,data);
        this.data=data;
        this.phone=phonenumber;
        this.context=context;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      // LayoutInflater layoutInflater=context.getLayoutInflater();
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.list_item_view,null);
        TextView textView=(TextView) convertView.findViewById(R.id.list);
        textView.setText(data[position]);
        TextView textView2=(TextView) convertView.findViewById(R.id.textView4);
        textView2.setText(phone[position]);

        return convertView;
    }
}

