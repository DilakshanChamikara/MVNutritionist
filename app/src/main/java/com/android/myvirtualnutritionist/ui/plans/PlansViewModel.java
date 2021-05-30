package com.android.myvirtualnutritionist.ui.plans;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlansViewModel extends ViewModel {

    private MutableLiveData<String> availablePlans;

    public PlansViewModel() {
        availablePlans = new MutableLiveData<>();
        availablePlans.setValue("Available Plans");
    }

    public MutableLiveData<String> getAvailablePlans() {
        return availablePlans;
    }
}