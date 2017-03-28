package com.mobileappscompany.training.myserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int RECOVER_TEXT = 1;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void show2Activity(View view) {
        MyParcelable parcelable = new MyParcelable();
        parcelable.setText(editText.getText().toString());

        Intent i = new Intent("AnyName");
        i.putExtra("parcelable",parcelable);
        startActivityForResult(i, RECOVER_TEXT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RECOVER_TEXT){
            if(resultCode == RESULT_OK){

                MyParcelable myParcelable = data.getParcelableExtra("parcelable");

                editText.setText(myParcelable.getText());
            }
        }
    }
}
