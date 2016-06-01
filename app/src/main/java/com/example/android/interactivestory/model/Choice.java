package com.example.android.interactivestory.model;

/**
 * Created by anant on 2016-06-01.
 */
public class Choice {

    private String mText;
    private int mNextPage;


    public Choice( String text,int nextPage){


        mNextPage = nextPage;
        mText = text;


    }
    public void setText(String mText) {
        this.mText = mText;
    }

    public void setNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }

    public String getText() {

        return mText;
    }

    public int getNextPage() {
        return mNextPage;
    }
}
