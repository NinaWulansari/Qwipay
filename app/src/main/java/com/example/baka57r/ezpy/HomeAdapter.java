package com.example.baka57r.ezpy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] text;
    private final int[] images;


    public HomeAdapter(Context c, String[] text, int[] images) {
        mContext = c;
        this.text = text;
        this.images = images;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            grid = new View (mContext);
            grid = inflater.inflate(R.layout.gridview_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.textView);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView);
            textView.setText(text[position]);
            imageView.setImageResource(images[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}