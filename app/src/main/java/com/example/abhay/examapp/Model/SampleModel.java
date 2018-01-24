package com.example.abhay.examapp.Model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abhay.examapp.BR;


public class SampleModel extends BaseObservable {
    private String username, useremail;
    private boolean isOnline;

    public SampleModel(String username, String useremail, boolean value) {
        this.username = username;
        this.useremail = useremail;
        isOnline = value;
    }

    @Bindable
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
        notifyChange();
    }

    @Bindable
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
        notifyChange();
    }

    @Bindable
    public boolean isOnline() {
        return isOnline;
    }


    public void setOnline(boolean online) {
        isOnline = online;
        notifyPropertyChanged(BR.online);
    }
}