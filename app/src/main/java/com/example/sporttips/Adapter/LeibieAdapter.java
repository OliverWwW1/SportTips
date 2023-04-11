package com.example.sporttips.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.sporttips.R;

import java.util.List;

public class LeibieAdapter extends BaseAdapter {
    private List<String> mList;
    private LayoutInflater layoutInflater;

    public LeibieAdapter(Context context, List<String> list) {
        mList = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public View getView(int j, View view, ViewGroup viewGroup) {
        int i = mList.size() - j - 1;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.aaa, null);
            viewHolder.textView = (TextView) view.findViewById(R.id.list_leibie);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.dengjicolor);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(mList.get(i).toString());

        return view;
    }

    public final class ViewHolder {
        public TextView textView, textView1, textView2, textView3, textView4;
        public ImageView imageView;
    }
}