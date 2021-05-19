package com.hdecstudio.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.hdecstudio.listview.adapter.Adapter;
import com.hdecstudio.listview.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView,listView2;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadTabHost();
        loadData();
    }

    void init(){
        listView = findViewById(R.id.listView);
        listView2 = findViewById(R.id.listView2);
        tabHost = findViewById(R.id.tabHost);
    }

    void loadTabHost(){
        tabHost.setup();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("Basic");
        tab1.setIndicator("Basic");
        tab1.setContent(R.id.listView);
        tabHost.addTab(tab1);

        tabHost.setup();
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Custom");
        tab2.setIndicator("Custom");
        tab2.setContent(R.id.listView2);
        tabHost.addTab(tab2);
    }

    void loadData(){
        //BASIC
        String[] list = {"Hector","Javier","Rosario","Jorge","Ana"};

        ArrayAdapter adapter = new
                ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cadena = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_SHORT).show();
            }
        });

        //CUSTOM
        ArrayAdapter customAdapter = new
                ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,list);
        listView2.setAdapter(customAdapter);

        ArrayList<User> user = new ArrayList<>();
        user.add(new User("Hector",getIconId(1)));
        user.add(new User("Maria",getIconId(2)));
        user.add(new User("Jose",getIconId(1)));
        user.add(new User("Javier",getIconId(1)));
        user.add(new User("Ana",getIconId(2)));

        //Toast.makeText(MainActivity.this, getIconId(1), Toast.LENGTH_SHORT).show();

        Adapter adapter2 = new Adapter(this, user);
        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User u = (User) listView2.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, u.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getIconId(int n){
        int id = 0;
        switch (n){
            case 1:
                id = getResources().getIdentifier("man","drawable",getPackageName());
                break;
            case 2:
                id = getResources().getIdentifier("girl","drawable",getPackageName());
                break;
        }

        return id;
    }

}