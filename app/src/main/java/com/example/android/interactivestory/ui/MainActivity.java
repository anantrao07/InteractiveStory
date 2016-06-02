package com.example.android.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.interactivestory.R;

public class MainActivity extends Activity {

    Button mBeginStroy;
    EditText mStoryName;
    Intent intent;
    String mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBeginStroy = (Button)findViewById(R.id.button);
        mStoryName = (EditText)findViewById(R.id.editText);


        mBeginStroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mName = mStoryName.getText().toString();
                intent = new Intent(getApplicationContext() , StoryActivity.class);
                intent.putExtra("Name" , mName);
               startActivity(intent);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mStoryName.setText("");
    }
}
