package com.jcode.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> names;
    Map<String,List<String>> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView = findViewById(R.id.expandable_list);
        getData();
        MyAdapter myAdapter = new MyAdapter(this,names,movies);
        expandableListView.setAdapter(myAdapter);

    }

    private void getData() {
        names = new ArrayList<>();
        names.add("Thura Linn");
        names.add("Han Htut San");
        names.add("Eden Hazard");



        movies = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");

        List<String> list2 = new ArrayList<>();
        list2.add("five");
        list2.add("five");
        list2.add("six");
        list2.add("seven");

        List<String> list3 = new ArrayList<>();
        list3.add("eight");
        list3.add("nine");
        list3.add("three");
        list3.add("three");
        list3.add("three");


        movies.put(names.get(0),list1);
        movies.put(names.get(1),list2);
        movies.put(names.get(2),list3);





    }
}