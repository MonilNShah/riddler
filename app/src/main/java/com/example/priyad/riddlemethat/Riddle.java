package com.example.priyad.riddlemethat;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


import java.util.ArrayList;
import java.util.List;


public class Riddle implements Parcelable {

    private String title;
    private String riddle;
    private List<String> answers;
    private boolean correct;
    private String author;
    private int id;

    public Riddle(String title, String riddle, String author, List<String> answers) {
        this.title = title;
        this.riddle = riddle;
        this.answers = answers;
        this.correct = false;
    }



    public List<String> getAnswers() {
        return this.answers;
    }

    public boolean checkAnswer(String hash) {
        for (String h: this.answers) {
            if (hash.equals(h)) {
                return true;
            }
        }
        return false;
    }

    public void setAnswer(List<String> answer) {
        this.answers = answer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }



    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.riddle);
        parcel.writeStringList(this.answers);

        parcel.writeInt(this.id);
    }

    public static final Parcelable.Creator<Riddle> CREATOR
            = new Parcelable.Creator<Riddle>() {
        public Riddle createFromParcel(Parcel in) {
            return new Riddle(in);
        }

        public Riddle[] newArray(int size) {
            return new Riddle[size];
        }
    };

    private Riddle(Parcel in) {
        this.title = in.readString();
        this.riddle = in.readString();
        this.answers = in.createStringArrayList();

        this.id = in.readInt();
    }


}

