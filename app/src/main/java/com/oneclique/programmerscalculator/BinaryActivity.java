package com.oneclique.programmerscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class BinaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);

        EditText mEditTextDecimalResult = findViewById(R.id.mEditTextDecimalResult);
        Clicked clicked = new Clicked(getApplicationContext(), mEditTextDecimalResult, 'b');

        (findViewById(R.id.mButton0)).setOnClickListener(clicked);
        (findViewById(R.id.mButton1)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonAND)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonOR)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonNAND)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonNOT)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonMultiply)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonDivide)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonAddition)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonSubtract)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonClear)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonEquals)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonDel)).setOnClickListener(clicked);
    }
}
