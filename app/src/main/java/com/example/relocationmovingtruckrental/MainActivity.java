package com.example.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    int intMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText miles = (EditText) findViewById(R.id.txtMiles);
        final RadioButton ten = (RadioButton) findViewById(R.id.rb10);
        final RadioButton seventeen = (RadioButton) findViewById(R.id.rb17);
        final RadioButton twentysix = (RadioButton) findViewById(R.id.rb26);
        Button button = (Button) findViewById(R.id.btnCost);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ApplySharedPref")
            @Override
            public void onClick(View v) {
                intMiles = Integer.parseInt(miles.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intMiles);
                editor.putBoolean("tenChecked", ten.isChecked());
                editor.putBoolean("seventeenChecked", seventeen.isChecked());
                editor.putBoolean("twentysixChecked", twentysix.isChecked());
                editor.commit();
                startActivity(new Intent(MainActivity.this, Cost.class));
            }
        });
    }
}
