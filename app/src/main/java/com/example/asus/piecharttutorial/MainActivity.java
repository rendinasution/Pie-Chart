package com.example.asus.piecharttutorial;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    float rainfall[] = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f, 16.89f, 23.9f};
    String monthNames[] = {"Mitch", "Jessica", "Mohammad", "Kelsey", "Sam", "Robert", "Ashley"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPieChart();
    }

    private void setupPieChart() {
        // Populating a list of PieEntries:
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < rainfall.length; i++) {
            pieEntries.add(new PieEntry(rainfall[i], monthNames[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Rainfall for Vancouver");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);


        // Get the chart
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }
}