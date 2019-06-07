package com.oneclique.programmerscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DecimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal);

        EditText mEditTextDecimalResult = findViewById(R.id.mEditTextDecimalResult);
        Clicked clicked = new Clicked(getApplicationContext(), mEditTextDecimalResult, 'd');

        (findViewById(R.id.mButton0)).setOnClickListener(clicked);
        (findViewById(R.id.mButton1)).setOnClickListener(clicked);
        (findViewById(R.id.mButton2)).setOnClickListener(clicked);
        (findViewById(R.id.mButton3)).setOnClickListener(clicked);
        (findViewById(R.id.mButton4)).setOnClickListener(clicked);
        (findViewById(R.id.mButton5)).setOnClickListener(clicked);
        (findViewById(R.id.mButton6)).setOnClickListener(clicked);
        (findViewById(R.id.mButton7)).setOnClickListener(clicked);
        (findViewById(R.id.mButton8)).setOnClickListener(clicked);
        (findViewById(R.id.mButton9)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonMultiply)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonDivide)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonAddition)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonSubtract)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonEquals)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonSign)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonDel)).setOnClickListener(clicked);
        (findViewById(R.id.mButtonClear)).setOnClickListener(clicked);

    }
}
