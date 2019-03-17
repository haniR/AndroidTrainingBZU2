package tech.cs.androidtrainingbzu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.zip.Inflater;

public class Pic_fragment extends Fragment {
    ImageView imageView3 ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.pic_fragment,container,false);
        imageView3 = (ImageView)v.findViewById(R.id.imageviewfragment);
        //Bundle b=getArguments();

        Bitmap bitmap =getArguments().getParcelable(HW2.MSG1);//getArguments().getParcelable(HW2.MSG1);
        imageView3.setImageBitmap(bitmap);
        return  v;
    }




}
