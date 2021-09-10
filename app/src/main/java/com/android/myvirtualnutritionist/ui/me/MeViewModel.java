package com.android.myvirtualnutritionist.ui.me;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.myvirtualnutritionist.R;

public class MeViewModel extends ViewModel {

    private MutableLiveData<Integer> meProfilePic;
    private MutableLiveData<String> status;
    private MutableLiveData<String> fName;
    private MutableLiveData<String> lName;

    public MeViewModel() {
        meProfilePic = new MutableLiveData<>();
        meProfilePic.setValue(R.drawable.profilepic);

        status = new MutableLiveData<>();
        status.setValue("Feeling Awesome ❤❤");

        fName = new MutableLiveData<>();
        fName.setValue("Geethma");

        lName = new MutableLiveData<>();
        lName.setValue("Bandara");
    }

    public LiveData<Integer> getMeProfilePic() {
        return meProfilePic;
    }

    public LiveData<String> getStatus() {
        return status;
    }

    public LiveData<String> getfName() {
        return fName;
    }

    public LiveData<String> getlName() {
        return lName;
    }

}