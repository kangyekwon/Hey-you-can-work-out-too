package org.tensorflow.lite.examples.detection;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

public class FrontActivity extends Activity {
    Button btn_to_activity;
    ImageView front;
    ImageView front3;
    // BackPressHandler 객체 선언, 할당
    private BackPressHandler backPressHandler = new BackPressHandler(this);
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
        btn_to_activity = findViewById(R.id.to_activity);

        front = (ImageView)findViewById(R.id.front);
        front.setImageResource(R.drawable.icon_front_02);

        front3 = (ImageView)findViewById(R.id.front3);
        front3.setImageResource(R.drawable.title01);


        btn_to_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(intent);
            }


        });

    }

    @Override
    public void onBackPressed() {
        // Default
        backPressHandler.onBackPressed();
    }
}