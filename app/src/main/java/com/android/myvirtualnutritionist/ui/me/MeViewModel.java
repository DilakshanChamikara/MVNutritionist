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
    private MutableLiveData<String> age;
    private MutableLiveData<String> gender;
    private MutableLiveData<String> diseaseType;
    private MutableLiveData<String> height;
    private MutableLiveData<String> weight;

    public MeViewModel() {
        meProfilePic = new MutableLiveData<>();
        meProfilePic.setValue(R.drawable.profilepic);

        status = new MutableLiveData<>();
        status.setValue("Feeling Awesome ❤❤");

        fName = new MutableLiveData<>();
        fName.setValue("Geethma");

        lName = new MutableLiveData<>();
        lName.setValue("Bandara");

        age = new MutableLiveData<>();
        age.setValue("23");

        gender = new MutableLiveData<>();
        gender.setValue("Female");

        diseaseType = new MutableLiveData<>();
        diseaseType.setValue("CardioVascularType-1");

        height = new MutableLiveData<>();
        height.setValue("125");

        weight = new MutableLiveData<>();
        weight.setValue("52");
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

    public LiveData<String> getAge() {
        return age;
    }

    public LiveData<String> getGender() {
        return gender;
    }

    public LiveData<String> getDiseaseType() {
        return diseaseType;
    }

    public LiveData<String> getHeight() {
        return height;
    }

    public LiveData<String> getWeight() {
        return weight;
    }
}