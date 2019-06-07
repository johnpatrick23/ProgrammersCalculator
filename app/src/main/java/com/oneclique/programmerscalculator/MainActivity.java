package com.oneclique.programmerscalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoToActivity goToActivity = new GoToActivity();
        (findViewById(R.id.mButtonDecimal)).setOnClickListener(goToActivity);
        (findViewById(R.id.mButtonBinary)).setOnClickListener(goToActivity);
        (findViewById(R.id.mButtonHexadecimal)).setOnClickListener(goToActivity);
        (findViewById(R.id.mButtonOctadecimal)).setOnClickListener(goToActivity);

    }

    private class GoToActivity implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.mButtonHexadecimal:{
                    intent = new Intent(MainActivity.this, HexadecimalActivity.class);
                    break;
                }
                case R.id.mButtonOctadecimal:{
                    intent = new Intent(MainActivity.this, OctaDecimalActivity.class);
                    break;
                }
                case R.id.mButtonBinary:{
                    intent = new Intent(MainActivity.this, BinaryActivity.class);
                    break;
                }
                case R.id.mButtonDecimal:{
                    intent = new Intent(MainActivity.this, DecimalActivity.class);
                    break;
                }
            }
            startActivity(intent);
        }

    }
}
