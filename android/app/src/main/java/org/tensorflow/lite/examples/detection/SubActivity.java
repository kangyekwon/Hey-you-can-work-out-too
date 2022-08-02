package org.tensorflow.lite.examples.detection;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SubActivity extends Activity {

    public ListView foodView;
    ArrayList<String> foodStrings = new ArrayList<String>();
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn2 = findViewById(R.id.btn2);
        final Bundle bundle = new Bundle();
        foodView = findViewById(R.id.food_list);
//    textView = (TextView) findViewById(R.id.rec_food);

        btn3 = findViewById(R.id.btn3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DetectorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urls = "https://www.youtube.com/results?search_query=";
                Intent intent = getIntent();
                String name0 = intent.getExtras().getString("name0");
                Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls+name0));
                startActivity(intents);
            }
        });

    }
}