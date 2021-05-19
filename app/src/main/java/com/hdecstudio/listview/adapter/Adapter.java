package com.hdecstudio.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hdecstudio.listview.MainActivity;
import com.hdecstudio.listview.R;
import com.hdecstudio.listview.entity.User;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<User> items;

    public Adapter(Activity activity, ArrayList<User> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<User> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item, null);
        }

        User user = items.get(position);

        try {
            if ( user.getIcon() != 0 ){
                ImageView image = (ImageView) v.findViewById(R.id.icon);
                image.setImageResource(user.getIcon());

            }
        }catch (Exception e){
            Log.i("Mensaje",e.getMessage().toString());
        }

        TextView name = (TextView) v.findViewById(R.id.name);
        name.setText(user.getName());

        return v;
    }
}
