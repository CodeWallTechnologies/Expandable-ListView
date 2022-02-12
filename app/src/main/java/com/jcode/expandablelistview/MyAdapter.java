package com.jcode.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> names;
    Map<String, List<String>> movies;


    public MyAdapter(Context context, List<String> names, Map<String, List<String>> movies) {
        this.context = context;
        this.names = names;
        this.movies = movies;
    }

    @Override
    public int getGroupCount() {
        return names.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return movies.get(names.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return names.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return movies.get(names.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String lang = (String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_list,null);
        }
        TextView txtparent = convertView.findViewById(R.id.parentList);
        txtparent.setText(lang);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String topic = (String) getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_list,null);
        }
        TextView textChild = convertView.findViewById(R.id.childList);
        textChild.setText(topic);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
