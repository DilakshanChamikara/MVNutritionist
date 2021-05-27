package com.android.myvirtualnutritionist.ui.diary.nutrition;

public class NutrientsTableDataModel {
    private String nutrientsName;
    private String total;
    private String goal;
    private String left;

    public NutrientsTableDataModel(String nutrientsName, String total, String goal, String left) {
        this.nutrientsName = nutrientsName;
        this.total = total;
        this.goal = goal;
        this.left = left;
    }

    public String getNutrientsName() {
        return nutrientsName;
    }

    public String getTotal() {
        return total;
    }

    public String getGoal() {
        return goal;
    }

    public String getLeft() {
        return left;
    }
}
