package com.journaldev.retrofitintro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WeltesDev on 12/20/2017.
 */

public class HeadMarkAdapter extends BaseAdapter{
    private Context context;
    private List<String> list = new ArrayList<>();

    public HeadMarkAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //disini nanti akan di pakai untuk mengarahkan ke xml yang mana
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(list.get(position));
        return convertView;
    }
}
