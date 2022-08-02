package org.tensorflow.lite.examples.detection;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SubActivity extends Activity {

    private String drwNoUrl = "https://dhlottery.co.kr/gameResult.do?method=byWin";
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat = "";
    private String nowCnt = "" ;
    String TAG = "Lotto" ;
    public ListView foodView;
    ArrayList<String> foodStrings = new ArrayList<String>();
    Button btn2;
    Button btn3;

    private class JsoupAsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, Arrays.toString(params));
            try {
                // 파라미터로 넘어온 값을 이용해서 url 와 회차를 설정한다.
                String callUrl = params[0] + "&drwNo=" + params[1];
                Document doc = Jsoup.connect(callUrl).get();
                // 위의 html tag에서 결과숫자를 싸고 있는 span tag 을 class명을 이용함.
                Elements links = doc.select(".ball_645");
                Log.e(TAG, "links=" + links.size());
                htmlContentInStringFormat += "회차=" + nowCnt ;
                for(Element el : links) {
                    Log.e(TAG, el.text()) ;
                    htmlContentInStringFormat += " " + el.text() ;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            textviewHtmlDocument.setText(htmlContentInStringFormat);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn2 = findViewById(R.id.btn2);
        final Bundle bundle = new Bundle();
//        foodView = findViewById(R.id.food_list);
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
        textviewHtmlDocument = (TextView) findViewById(R.id.textView);
        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());

        Button htmlTitleButton = (Button) findViewById(R.id.button2);
        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nowCnt = "969"; // 2021.06.30 기준 마지막 회차
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute(drwNoUrl, nowCnt);

            }
        });
    }
//    여기부터는 이제 만드는중 /// 운동 종류 jsoup
//    1

}