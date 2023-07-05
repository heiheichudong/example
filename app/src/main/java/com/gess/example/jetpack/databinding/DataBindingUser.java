package com.gess.example.jetpack.databinding;

import androidx.databinding.BaseObservable;

import com.gess.example.BR;

public class DataBindingUser extends BaseObservable {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
