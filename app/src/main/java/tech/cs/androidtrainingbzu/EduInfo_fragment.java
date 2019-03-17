package tech.cs.androidtrainingbzu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class EduInfo_fragment extends Fragment {
    EditText genderfr,expfr,wantfr;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v= inflater.inflate(R.layout.pic_fragment,container,false);
            genderfr = (EditText)v.findViewById(R.id.genderfragment);
            expfr = (EditText)v.findViewById(R.id.experiencefragment);
            wantfr = (EditText)v.findViewById(R.id.wantfragment);
            return  v;
        }
    }

