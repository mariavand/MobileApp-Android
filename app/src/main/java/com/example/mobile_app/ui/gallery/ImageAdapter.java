package com.example.mobile_app.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.mobile_app.R;

public class ImageAdapter  extends BaseAdapter {

    //Declaration of Context variable
    private final Context mContext;

    // Constructor
    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    // Returns 6, imageArray is declared in GalleryFragment
    @Override
    public int getCount() {

        return imageArray.length;
    }

    // Returns an image
    @Override
    public Object getItem(int position) {

        return imageArray[position];
    }

    // Returns 0.000
    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create a new object of ImageView class
        ImageView imageView = new ImageView(mContext);

        // Set Image Resource with the array of images
        imageView.setImageResource(imageArray[position]);

        // Images have different sizes so we centrilize the picture and crop it (320px*320px)
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(320, 320));

        //Returns ImageView
        return imageView;
    }

    //An array of images available in res/drawable
    public int[] imageArray = {
            R.drawable.covidpic, R.drawable.covidpic2, R.drawable.covidpic3,
            R.drawable.news1, R.drawable.news2, R.drawable.news3
    };
}