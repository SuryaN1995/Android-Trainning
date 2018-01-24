package com.example.abhay.examapp.Networking;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.abhay.examapp.R;

import java.util.List;

import static android.content.Context.JOB_SCHEDULER_SERVICE;


public class SchedulerFragment extends Fragment {


    private static final int MYJOBID = 1;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Chronometer chronometer;
    Button btnStartJob, btnCancelJobs;
    JobScheduler jobScheduler;
    Toolbar toolbar;
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;


    public SchedulerFragment() {

    }


    public static SchedulerFragment newInstance(String param1, String param2) {
        SchedulerFragment fragment = new SchedulerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_scheduler, container, false);
        chronometer = v.findViewById(R.id.chronometer);
        btnStartJob = v.findViewById(R.id.startjob);
        btnCancelJobs = v.findViewById(R.id.canceljobs);
        jobScheduler = (JobScheduler) getActivity().getSystemService(JOB_SCHEDULER_SERVICE);
        setupToolbar();


        btnStartJob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();


                ComponentName jobService =
                        new ComponentName(getActivity().getPackageName(), MyJobService.class.getName());
                JobInfo jobInfo =
                        new JobInfo.Builder(MYJOBID, jobService).setMinimumLatency(10000).build();


                int jobId = jobScheduler.schedule(jobInfo);
                if (jobScheduler.schedule(jobInfo) > JobScheduler.RESULT_FAILURE) {
                    Toast.makeText(getActivity(),
                            "Successfully scheduled job: " + jobId,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),
                            "RESULT_FAILURE: " + jobId,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnCancelJobs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chronometer.stop();

                List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
                String s = "";
                for (JobInfo j : allPendingJobs) {
                    int jId = j.getId();
                    jobScheduler.cancel(jId);
                    s += "jobScheduler.cancel(" + jId + " )";
                }


                Toast.makeText(getActivity(),
                        s,
                        Toast.LENGTH_SHORT).show();


            }
        });
        return v;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    void setupToolbar() {
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.a);
        toolbar.setTitle("Scheduler");
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

