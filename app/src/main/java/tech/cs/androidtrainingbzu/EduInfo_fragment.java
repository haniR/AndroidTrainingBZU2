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
            View v= inflater.inflate(R.layout.edu_info_fragment,container,false);
            String genders = getArguments().getString("gender");
            String exps = getArguments().getString("experiance");
            String wants = getArguments().getString("wantlearn");
            genderfr.setText(genders);
            expfr.setText(exps);
            wantfr.setText(wants);
            return  v;
        }
    }

