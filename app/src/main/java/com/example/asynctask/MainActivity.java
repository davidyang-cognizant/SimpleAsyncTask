package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
    }

    public void handleCharge(View view) {
        SimpleAsyncTask simpleAsyncTask = new SimpleAsyncTask(progressBar, progressBar2);
        simpleAsyncTask.execute("some string");
    }
}