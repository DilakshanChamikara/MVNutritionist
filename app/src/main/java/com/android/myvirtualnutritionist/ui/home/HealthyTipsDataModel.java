package com.android.myvirtualnutritionist.ui.home;

public class HealthyTipsDataModel {
    int tipImage;
    String tipTitle, tipDesc;

    public HealthyTipsDataModel(int tipImage, String tipTitle, String tipDesc) {
        this.tipImage = tipImage;
        this.tipTitle = tipTitle;
        this.tipDesc = tipDesc;
    }

    public int getTipImage() {
        return tipImage;
    }

    public void setTipImage(int tipImage) {
        this.tipImage = tipImage;
    }

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public String getTipDesc() {
        return tipDesc;
    }

    public void setTipDesc(String tipDesc) {
        this.tipDesc = tipDesc;
    }
}
