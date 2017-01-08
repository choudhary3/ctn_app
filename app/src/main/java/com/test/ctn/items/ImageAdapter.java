package com.test.ctn.items;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.test.ctn.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.aloo_paratha, R.drawable.bread_pakora,
            R.drawable.burger, R.drawable.cheese_sandwich,
            R.drawable.chole_bhature, R.drawable.chole_kulche,
            R.drawable.idli_sambar, R.drawable.khamand,
            R.drawable.masala_dosa, R.drawable.paneer_paratha,
            R.drawable.pav_bhaji, R.drawable.cheese_sandwich,
            R.drawable.pizza
    };
}