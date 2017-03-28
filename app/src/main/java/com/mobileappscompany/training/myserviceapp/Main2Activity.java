package com.mobileappscompany.training.myserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyParcelable myParcelable = getIntent().getParcelableExtra("parcelable");

        editText = (EditText) findViewById(R.id.editText2);
        editText.setText(myParcelable.getText());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onGoB(null);
    }

    public void onGoB(View view){
        Intent returnIntent = new Intent();

        MyParcelable parcelable = new MyParcelable();
        parcelable.setText(editText.getText().toString());

        returnIntent.putExtra("parcelable",parcelable);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
