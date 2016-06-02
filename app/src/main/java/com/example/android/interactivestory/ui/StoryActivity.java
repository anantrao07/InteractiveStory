package com.example.android.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.interactivestory.R;
import com.example.android.interactivestory.model.Page;
import com.example.android.interactivestory.model.Story;

public class StoryActivity extends Activity {

    Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    Page mpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();

         mName  = intent.getStringExtra("Name");

        if(mName == null){
            mName = "Friend";

        }

        mImageView = (ImageView)findViewById(R.id.storyimageView);
        mTextView = (TextView)findViewById(R.id.storytextView);
        mChoice1 = (Button) findViewById(R.id.choicebutton1);
        mChoice2 = (Button)findViewById(R.id.choicebutton2);

        loadPage(0);

    }

    public void loadPage(int choice){

          mpage =  mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mpage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mpage.getText();

        //to replace the name of the place holer in the string value , wont change if the placeholder is not present
        pageText = String.format(pageText,mName);

        mTextView.setText(pageText);

        if(mpage.isFinal()){

            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });



        }
        else {
            mChoice1.setText(mpage.getchoice1().getText());
            mChoice2.setText(mpage.getchoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mpage.getchoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mpage.getchoice2().getNextPage();
                    loadPage(nextPage);
                }
            });


        }
    }
}
