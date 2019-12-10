package com.example.pst4;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class CarPictureAdapter extends BaseAdapter {
    private Context mContext;

    public CarPictureAdapter(Context context ){
        this.mContext = context;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position){
        return mThumbIds[position];
    }

    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(370,370));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView) convertView;
        }
        Bitmap bitmap = bitmapList.get(0);
        imageView.setImageBitmap(bitmap);
        //imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }

    public List<Bitmap> bitmapList = new ArrayList<Bitmap>();

    public Integer[] mThumbIds = {
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_arrow_forward_24px, R.drawable.round_arrow_forward_black_18dp,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground

    };
}
