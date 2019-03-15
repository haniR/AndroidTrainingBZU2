package tech.cs.androidtrainingbzu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class HW2Result extends AppCompatActivity {
    EditText name,email,phone,gender,exp,want,births;
    ImageView imageview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2_result);
        name = (EditText)findViewById(R.id.nameis);
        email = (EditText)findViewById(R.id.emailis);
        phone = (EditText)findViewById(R.id.phoneis);
        gender = (EditText)findViewById(R.id.genderis);
        exp = (EditText)findViewById(R.id.experienceis);
        want = (EditText)findViewById(R.id.wantis);
        births = (EditText)findViewById(R.id.birthis);
        imageview2 = (ImageView)findViewById(R.id.imageView2);
        Bundle extras = getIntent().getExtras();
        String names = extras.getString("name");
        String emails = extras.getString("email");
        String phones = extras.getString("phone");
        String genders = extras.getString("gender");
        String exps = extras.getString("experiance");
        String wants = extras.getString("wantlearn");
        String birthss = extras.getString("date");
        Bitmap bitmap = extras.getParcelable(HW2.MSG1);
        imageview2.setImageBitmap(bitmap);
        name.setText(names);
        email.setText(emails);
        phone.setText(phones);
        gender.setText(genders);
        exp.setText(exps);
        want.setText(wants);
        births.setText(birthss);

    }

    public void edit(View view) {
        Intent intent = new Intent(getApplicationContext(),HW2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent,0);
    }
}
