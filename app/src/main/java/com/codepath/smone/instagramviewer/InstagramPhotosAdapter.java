package com.codepath.smone.instagramviewer;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by smone on 11/1/14.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> photos) {
        super(context, android.R.layout.simple_list_item_1, photos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item
        InstagramPhoto photo = getItem(position);
        //check if are using a recycled view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        //lookup sub views within the template
        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
        ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);
        //populate sub views
        tvCaption.setText(photo.caption);
        imgPhoto.getLayoutParams().height = photo.imageHeight;
        //Reset the image from the recycled view
        imgPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(imgPhoto);
        //return the view
        return convertView;

    }
}
