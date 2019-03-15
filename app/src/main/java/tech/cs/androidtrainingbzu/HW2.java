package tech.cs.androidtrainingbzu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HW2 extends AppCompatActivity {
    Spinner spinner;
    Button save,open,takepic;
    EditText name,email,phone;
    CheckBox javaCheck,cCheck,pythonCheck;
    RadioGroup radioGroup;
    RadioButton radioButton,rmale,rfemale;
    ImageView imageview;
    private ArrayList<String> exp;
    Bitmap bitmap;
    public static final String MSG1="MSG";
    public static final int REQUEST_SELECT_CONTACT=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2);
        spinner = (Spinner)findViewById(R.id.spinner);
        save = (Button)findViewById(R.id.save);
        open= (Button)findViewById(R.id.open);
        takepic = (Button)findViewById(R.id.takepic);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phoneView);
        javaCheck = (CheckBox)findViewById(R.id.java);
        cCheck = (CheckBox)findViewById(R.id.c);
        pythonCheck = (CheckBox)findViewById(R.id.python);
        radioGroup = (RadioGroup) findViewById(R.id.gender);
        rmale = (RadioButton) findViewById(R.id.male);
        imageview = (ImageView)findViewById(R.id.imageView);
        populateSpinner();
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                   startActivityForResult(intent,REQUEST_SELECT_CONTACT);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            bitmap= (Bitmap)data.getExtras().get("data");
            imageview.setImageBitmap(bitmap);
        }else  if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                phone.setText(number);
            }
        }
    }



    private  void  populateSpinner(){
        List<String> books = new ArrayList<>();
        books.add("Android");
        books.add("PHP");
        books.add("C++");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,books);
        spinner.setAdapter(adapter);
    }

    public void save(View view) {
        String spinch = spinner.getSelectedItem().toString();//get selected Spin
        String fName= name.getText().toString();//Get name
        String eemail = email.getText().toString();//Get email
        String pphone = phone.getText().toString();//Get Phone

        /* ******************************************************************************************************************************** */
        int radioId =radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        String genderIs = radioButton.getText().toString();//get gender
        //Toast.makeText(this, "you choice "+genderIs, Toast.LENGTH_SHORT).show();
        /* *********************************************************************************************** */
        exp = new ArrayList<>();

        if(javaCheck.isChecked()){
            exp.add("Java");
        }else{
            exp.remove("Java");
        }
        if(cCheck.isChecked()){
            exp.add("C");
        }else{
            exp.remove("C");
        }
        if(pythonCheck.isChecked()){
            exp.add("Python");
        }else{
            exp.remove("Python");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : exp)
            stringBuilder.append(s).append("\n");
        String s = stringBuilder.toString();
        Intent intent = new Intent(getApplicationContext(), HW2Result.class);
        Bundle extras = new Bundle();
        extras.putString("name",fName);
        extras.putString("email",eemail);
        extras.putString("phone",pphone);
        //extras.putString("imageview",bitmap);
        extras.putString("experiance",s);
        extras.putString("wantlearn",spinch);
        extras.putString("gender",genderIs);
        intent.putExtras(extras);
        intent.putExtra(MSG1,bitmap);
        startActivity(intent);

        //Toast.makeText(this, "choices is "+stringBuilder, Toast.LENGTH_SHORT).show();

        /* ********************************************************************************************* */

        //Toast.makeText(this, "Have a Credit : "+credit, Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "Your Name : "+fName+"\n"+"Your Gender Is : "+genderIs+"\n"+"Your Experence is " +
         //       ": " +s+"\n"+"You Want Learn : "+spinch+"\n", Toast.LENGTH_SHORT).show();


    }
}
