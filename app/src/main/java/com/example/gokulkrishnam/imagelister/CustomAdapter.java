package com.example.gokulkrishnam.imagelister;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by GOKULKRISHNA M on 13-07-2017.
 */

public class CustomAdapter extends ArrayAdapter<PhotoList> {


    private class ViewHolder{
        ImageView imgIcon;
        TextView captions;

    }


    public CustomAdapter(Activity context, ArrayList<PhotoList> photolist) {
        super(context,0, photolist);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProgressDialog dialog;
        dialog= new ProgressDialog(getContext());
        dialog.setMessage("Loading...");
        dialog.show();
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_adapter_view,parent,false);
            viewHolder.captions = (TextView)convertView.findViewById(R.id.myText);
            viewHolder.imgIcon = (ImageView)convertView.findViewById(R.id.myImage);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PhotoList image = getItem(position);
        viewHolder.captions.setText(image.getCaption());
        final int THUMBSIZE = 200;
        viewHolder.imgIcon.setImageURI(Uri.fromFile(new File(image.getPath())));

        viewHolder.imgIcon.setImageBitmap(ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(image.getPath()),THUMBSIZE, THUMBSIZE));
        dialog.hide();
        return convertView;


    }


}
