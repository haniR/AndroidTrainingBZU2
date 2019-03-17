package tech.cs.androidtrainingbzu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class UserInfo_fragmwnt extends Fragment {
    EditText namefr,emailfr,phonefr,birthfr;

    @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v= inflater.inflate(R.layout.user_info_fragment,container,false);
        String names = getArguments().getString("name");
        String emails = getArguments().getString("email");
        String phones = getArguments().getString("phone");
        String birthss = getArguments().getString("date");
        namefr.setText(names);
        emailfr.setText(emails);
        phonefr.setText(phones);
        birthfr.setText(birthss);
            return v;
        }
    }

