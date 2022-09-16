package com.example.helloworld;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;
import java.util.Locale;

public class MainActivity extends Activity {
    private Button btnExit;
    private EditText txtColorSelected;
    private TextView txtSpyBox;
    private LinearLayout myScreen;
    //private String PREFNAME = "filename";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtColorSelected = (EditText) findViewById(R.id.txtMsg);
        btnExit = (Button) findViewById(R.id.btnExit);
        txtSpyBox = (TextView) findViewById(R.id.txtSpy);
        myScreen = (LinearLayout) findViewById(R.id.myScreen);

        txtColorSelected.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String chosenColor = editable.toString().toLowerCase(Locale.US);
                txtSpyBox.setText(chosenColor);
                setBackgroundColor(chosenColor, myScreen);
            }
        });

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT ).show();
    }

    private void onClick(EventListener eventListener)
    {
        finish();
    }

    private void setBackgroundColor(String chosenColor, LinearLayout myScreen) {
        //hex color codes: 0xAARRGGBB AA:transparent, RR red, GG green, BB blue
        if (chosenColor.contains("ton")) myScreen.setBackgroundColor(0xffff0000); //Color.RED
        if (chosenColor.contains("nam")) myScreen.setBackgroundColor(0xff00ff00); //Color.GREEN
        if (chosenColor.contains("hung")) myScreen.setBackgroundColor(0xff0000ff); //Color.BLUE
        if (chosenColor.contains("hoang")) myScreen.setBackgroundColor(0xffffffff); //Color.WHITE
        if (chosenColor.contains("dai")) myScreen.setBackgroundColor(0xffff11ff); //Color.WHITE
    }
}