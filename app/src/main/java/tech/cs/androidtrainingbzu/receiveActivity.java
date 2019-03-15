package tech.cs.androidtrainingbzu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class receiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        ((TextView)findViewById(R.id.share)).setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }
}
