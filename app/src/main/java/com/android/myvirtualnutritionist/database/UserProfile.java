package com.android.myvirtualnutritionist.database;

import android.provider.BaseColumns;

public final class UserProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserProfile() {}

    /* Inner class that defines the table contents */
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_Username= "userName";
        public static final String COLUMN_UserStatus = "status";
        public static final String COLUMN_Pwd = "password";
        public static final String COLUMN_FName= "FName";
        public static final String COLUMN_LName = "LName";
        public static final String COLUMN_Age= "Age";
        public static final String COLUMN_Gender = "gender";
        public static final String COLUMN_Height= "height";
        public static final String COLUMN_Weight = "weight";
        public static final String COLUMN_BMI= "bmi";
        public static final String COLUMN_WeightStatus = "weightStatus";
        public static final String COLUMN_CalNeed= "CalNeed";
        public static final String COLUMN_CalGoal = "CalGoal";
    }
}