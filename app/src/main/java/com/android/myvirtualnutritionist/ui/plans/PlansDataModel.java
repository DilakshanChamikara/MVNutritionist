package com.android.myvirtualnutritionist.ui.plans;

public class PlansDataModel {

    int planImage;
    String planTitle, status;
    String planDate;

    public PlansDataModel(int planImage, String planTitle, String status, String planDate) {
        this.planImage = planImage;
        this.planTitle = planTitle;
        this.status = status;
        this.planDate = planDate;
    }

    public int getPlanImage() {
        return planImage;
    }

    public void setPlanImage(int planImage) {
        this.planImage = planImage;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }
}
