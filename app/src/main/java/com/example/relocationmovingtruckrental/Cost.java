package com.example.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cost extends AppCompatActivity {
    double truckCost;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        TextView totalCost = (TextView) findViewById(R.id.txtCost);
        ImageView image = (ImageView) findViewById(R.id.imgSize);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intMiles = sharedPref.getInt("key1", 0);
        Boolean ten = sharedPref.getBoolean("tenChecked", false);
        Boolean seventeen = sharedPref.getBoolean("seventeenChecked", false);
        Boolean twentysix = sharedPref.getBoolean("twentysixChecked", false);
        if (ten) {
            image.setImageResource(R.drawable.tenfeet);
            truckCost = 19.95;
        } else if (seventeen) {
            image.setImageResource(R.drawable.seventeenfeet);
            truckCost = 29.95;
        } else if (twentysix) {
            image.setImageResource(R.drawable.twentysixfeet);
            truckCost = 39.95;
        }
        double decTotalCost;
        decTotalCost = ((intMiles * 0.99) + truckCost);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        totalCost.setText("Total Cost for truck " + currency.format(decTotalCost));
    }
}
