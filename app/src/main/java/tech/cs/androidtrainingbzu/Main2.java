package tech.cs.androidtrainingbzu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2 extends AppCompatActivity {
    Button calculator,google,Myphone,Takepic,EmailSend,hw2,hw3;
    EditText emailTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        calculator= (Button)findViewById(R.id.calculator);
        google =(Button)findViewById(R.id.google);
        Myphone = (Button)findViewById(R.id.myphone);
        Takepic = (Button)findViewById(R.id.takepic);
        EmailSend = (Button)findViewById(R.id.sendEmail);
        emailTo = (EditText)findViewById(R.id.emailTo);
        hw2 = (Button)findViewById(R.id.hw2);
        hw3 = (Button)findViewById(R.id.hw3);


        EmailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                String mailto = "mailto:" +emailTo.getText().toString()+
                        "?cc=" + "email@example.com" +
                        "&subject=" + Uri.encode("Email Subject") +
                        "&body=" + Uri.encode("Email Body");
                intent = new Intent(Intent.ACTION_SENDTO);
                // Provide data as a URI
                //intent.setData(Uri.parse("mailto:"+edt_email.getText().toString()));
                intent.setData(Uri.parse(mailto));
                //Start the activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intint = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intint);

            }
        });
        Myphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:0595061389");
                Intent intint = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intint);

            }
        });
        hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HW2.class));
            }
        });
        hw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),recycleViewMovie.class));
            }
        });

    }

}
