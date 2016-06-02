package com.example.android.interactivestory.model;

/**
 * Created by anant on 2016-06-01.
 */
public class Page {


    private int mImageId;
    private String mText;
    private Choice mchoice1;
    private Choice mchoice2;
    private boolean mIsFinal = false;


    public Page(int imageId, String text , Choice choice1, Choice choice2){

        mImageId = imageId;
        mText = text;
        mchoice1 = choice1;
        mchoice2 = choice2;
    }

    public Page(int imageId, String text ){

        mImageId = imageId;
        mText = text;
        mchoice1 = null;
        mchoice2 = null;
        mIsFinal = true;
    }

    public boolean isFinal(){

        return mIsFinal;
    }
    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public void setchoice1(Choice mchoice1) {
        this.mchoice1 = mchoice1;
    }

    public void setchoice2(Choice mchoice2) {
        this.mchoice2 = mchoice2;
    }

    public int getImageId() {

        return mImageId;
    }

    public String getText() {
        return mText;
    }

    public Choice getchoice1() {
        return mchoice1;
    }

    public Choice getchoice2() {
        return mchoice2;
    }
}
