package com.example.onlineradioplayer.models;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineradioplayer.R;
import com.example.onlineradioplayer.models.RadioContent.RadioItem;


public class RadioListAdapter extends BaseAdapter {

   private Activity activity;
   private static LayoutInflater inflater=null;
   private List<RadioItem> data;
   public RadioListAdapter(Activity a, List<RadioItem> radios) {
       activity = a;
       data=radios;
   }

   public int getCount() {
       return data.size();
   }

   public Object getItem(int position) {
       return position;
   }

   public long getItemId(int position) {
       return position;
   }

   public View getView(int position, View convertView, ViewGroup parent) {
       View vi=convertView;
       if(convertView==null){
    	    inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);    	    
            vi = inflater.inflate(R.layout.radio_list,null);
       }
       
       RadioItem radio = data.get(position);
       ImageView imgIcon = (ImageView)vi.findViewById(R.id.imgIcon);
       TextView txvTitle = (TextView)vi.findViewById(R.id.txvTitle);
       
       
       // Setting all values in listview

       imgIcon.setImageResource(radio.icon);	
       txvTitle.setText(radio.title + " Radio");
       return vi;
   }
}