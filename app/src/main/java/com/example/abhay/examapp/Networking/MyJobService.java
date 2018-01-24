package com.example.abhay.examapp.Networking;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;


public class MyJobService extends JobService {

    public MyJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Toast.makeText(this,
                "MyJobServices.onStartJob()",
                Toast.LENGTH_SHORT).show();


        return false;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        Toast.makeText(this,
                "MyJobServices.onStopJob()",
                Toast.LENGTH_SHORT).show();
        return false;
    }

}