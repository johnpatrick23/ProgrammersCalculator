package com.oneclique.programmerscalculator;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

public class Clicked extends Print implements View.OnClickListener {

    private Context mContext;
    private EditText mEditTextResult;
    private char mSelectedType = '\0';

    Clicked(Context context, EditText txtResult, char type){
        this.mContext = context;
        this.mEditTextResult = txtResult;
        this.mSelectedType = type;
    }

    @Override
    public void onClick(View v) {
        print(mContext, v, mEditTextResult, mSelectedType);
    }
}
