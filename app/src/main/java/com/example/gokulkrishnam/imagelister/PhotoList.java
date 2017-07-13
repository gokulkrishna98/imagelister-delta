package com.example.gokulkrishnam.imagelister;

import android.graphics.Bitmap;

/**
 * Created by GOKULKRISHNA M on 13-07-2017.
 */

public class PhotoList {

    private String Caption,path;
    Bitmap photo;


    public void setCaptions(String Caption){

        this.Caption = Caption;

    }

    public String getCaption(){
        return Caption;
    }

    public void setPath(String path){
        this.path=path;
    }
    public String getPath(){
        return path;
    }


}
