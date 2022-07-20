package com.example.asynctask;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class SimpleAsyncTask extends AsyncTask<String, Integer, Bitmap> {


    @SuppressLint("StaticFieldLeak")
    private final ProgressBar progressBar;
    @SuppressLint("StaticFieldLeak")
    private final ProgressBar progressBar2;

    /**
     * Constructor for the class
     * @param progressBar - Progress bar
     * @param progressBar2 - Progress bar
     */
    public SimpleAsyncTask(ProgressBar progressBar, ProgressBar progressBar2) {
        this.progressBar = progressBar;
        this.progressBar2 = progressBar2;
    }

    /**
     * Before running the task, these set of commands will execute
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);
    }

    /**
     * This method runs in the background and allows for up to 5 tasks at once
     * @param strings - Passed in values
     * @return null
     */
    @Override //this method will execute on a background thread
    protected Bitmap doInBackground(String... strings) {
        Log.i("Async", "downloading--" + strings[0]);
        for (int i = 1; i < 21; i++){
            publishProgress(i*5);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Updates the current progress given by "publishProgress"
     * @param values - value to set the progress to
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        progressBar2.setProgress(values[0]);
    }

    /**
     * After the task is completed, return the bitmap image and other commands
     * @param bitmap - image to return
     */
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar2.setVisibility(View.INVISIBLE);
    }


}
