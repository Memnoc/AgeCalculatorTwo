package com.smartdroidesign.agecalculatortwo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String userBirthday;
    private String currentDate;

    public User(String userBirthday, String currentDate) {
        this.userBirthday = userBirthday;
        this.currentDate = currentDate;
    }

    protected User(Parcel in) {
        userBirthday = in.readString();
        currentDate = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userBirthday);
        dest.writeString(currentDate);
    }
}
