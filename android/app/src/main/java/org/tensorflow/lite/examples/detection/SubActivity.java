package org.tensorflow.lite.examples.detection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.util.Log;
import java.util.ArrayList;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SubActivity extends Activity {

    private String nowCnt = "";
    private String drwNoUrl = "https://namu.wiki/w/";
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat = "";
    public ListView foodView;
    public ScrollView sub_activity_page;
    ArrayList<String> foodStrings = new ArrayList<String>();
    ArrayList<Workout_Item> arrayList;
    // 버튼 선언
    Button button2;
    Button btn3;

    private class JsoupAsyncTask extends AsyncTask<String, Void, Void> {

        private String a1 = "\n기구 이름 : 체스트프레스머신" +
                "\n주운동 부위 : 가슴근육(대흉근)" +
                "\n부운동부위 : 상완삼두근 및 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.손잡이와 가슴 높이가 비슷하게 위치하도록 의자 높낮이를 조정해준다" +
                "\n2.가슴을 펴고 허리가 과하게 꺽이지 않게 바르게 펴고 팔을 앞으로 밀어준다 " +
                "\n3.손목, 팔꿈치를 일직선을 유지시킨 상태에서 팔꿈치를 뒤로 천천히 빼준다" +
                "\n\n효과 : 가슴 및 팔 근육을 키울 수 있다" +
                "\n\n주의점 : 손잡이를 잡을 때 너무 과하게 손목이 꺾이지 않기 , 불필요하게 승모에 힘주지 않기";

        private String a2 = "\n기구 이름 : 랫풀다운머신" +
                "\n주운동 부위 : 광배근" +
                "\n부운동부위 : 이두근" +
                "\n\n운동 방법 : " +
                "\n1.턱걸이를 하듯 어깨보다 좀 더 넓게 바를 잡는다" +
                "\n2.상체를 뒤로 젖히고 팔이 아니라 등의 힘으로 당겨 내려온다" +
                "\n*턱걸이와 가동부위는 거의 같으며, 좁게 잡을수록 광배근 안쪽이, 넓게 잡을수록 상부와 바깥쪽이 발달된다" +
                "\n\n효과 : 광배근을 발달시키기 위한 대표적인 운동이다, 턱걸이를 하기 어려운 초보자들에게 좋은 운동이다" +
                "\n\n주의점 : 팔만 이용하여 바(bar)를 잡아당기면 이두근의 참여도가 지나치게 높아지므로 동작을 시작하는 시점에서 견갑골(날개뼈)을 우선적으로 내리도록 한다";

        private String a3 = "\n기구 이름 : 시티드로우" +
                "\n주운동 부위 : 광배근" +
                "\n부운동부위 : 중부 승모근 , 하부 승모근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아서 발판에 발을 올리고 그립을 잡고 척추를 바르게 편다 " +
                "\n2.호흡을 들이마시며 가슴을 들고 견갑골을 모아주며 그립을 당겨준다 " +
                "\n3.숨을 내뱉으며 팔과 견갑골을 펴준다" +
                "\n\n효과 : 등 근육의 크기를 키우는 운동으로 광배근 하부 크기에 관여하는 운동 , 벤트 오버 로우 동작을 앉아서 케이블을 이용해 하는 운동이다" +
                "\n\n주의점 : 팔꿈치로 당긴다기보다 견갑곱을 모으는데 집중해주고 척추중립을 유지해준다";

        private String a4 = "\n기구 이름 : 암컬머신" +
                "\n주운동 부위 : 상완이두근" +
                "\n부운동부위 : 전완근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 바벨을 어깨 너비로 잡는다 " +
                "\n2.가슴과 팔을 패드에 고정시킨 후 손을 몸쪽으로 올려 이두를 수축시킨다 " +
                "\n*좁게 잡으면 장두 , 넓게 잡으면 단두운동이된다 " +
                "\n\n효과 : 고정된 팔꿈치로 인해 강력한 상완 이두근 운동을 할 수 있는 머신이다. 등, 어깨의 개입을 최소화 하여 오직 이두에만 집중하기 위한 머신" +
                "\n\n주의점 :  손목이 안으로 꺽이지 않게 한다. 반동을 이용하지 않는다";

        private String a5 = "\n기구 이름 : 체스트 플라이 머신" +
                "\n주운동 부위 : 대흉근(가슴) 내측근(중앙)" +
                "\n부운동부위 : 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 허리는 살짝 아치형을 만든후 손잡이를 잡은 뒤 ,가슴을 모아준다 " +
                "\n2.가슴을 늘려준다는 느낌으로 천천히 이완한다 " +
                "\n*팔힘을 이용해 수축시켜 주는 느낌이 아닌, 겨드랑이에 힘을 주고 가슴을 모아준다는 느낌으로 수축시켜준다" +
                "\n\n효과 : 운동을 처음 시작하는 초보자들이 덤벨 플라이를 실시하기 전에 근육의 자극을 경험하고 자세를 교정하는 데 효과적이다. 대흉근에집중하기에 좋은 운동이다" +
                "\n\n주의점 : 다리를 사용하지 않는다, 허리가 굽히지 않게 신경쓰면서 천천히 수축 이완을 한다";

        private String a6 = "\n기구 이름 : 치닝디핑 (1번은 가슴, 2번은 등)" +
                "\n\n1번\n주운동 부위 : 가슴(대흉근) 하부" +
                "\n부운동부위 : 삼각근, 삼두" +
                "\n\n운동 방법 : " +
                "\n1.바를 잡고 팔꿈치를 펴고 선다" +
                "\n2.팔꿈치를 굽혀주면서 상체를 내려준다" +
                "\n3.팔꿈치를 다시 펴 원위치한다" +
                "\n\n주의점 :초보자의 경우 과도하게 내려가려다가 팔꿈치나 어깨가 망가질 수 있으니 주의해야한다 " +

                "\n\n2번\n주운동 부위 : 등" +
                "\n부운동부위 : 이두 " +
                "\n\n운동 방법 : " +
                "\n1.어깨넓이보다 약간 더 넓게 오버핸드그립(손목이 아래로 향하여 쥐는형태)자세로 점프하여 바를 잡는다   " +
                "\n2.등,코어,둔근을 자극하며 어깨뼈를 앞에서 뒤로 당긴다, 턱이 턱걸이 봉을 지날때까지 몸을 들어올린다" +
                "\n3.천천히 몸을 돌리며 다시 처음으로 돌아온다" +
                "\n\n주의점 :횟수보다는 올바른 방법이 중요하다, 동작이 안되면 밴드를 이용하거나 매달리기 부터 하길 권장한다";


        private String a7 = "\n기구 이름 : 레터럴레이즈머신" +
                "\n주운동 부위 : 측면 삼각근" +
                "\n부운동부위 : 전면 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 어깨선을 맞춰서 의자 높이를 조절한다" +
                "\n2.팔꿈치는 직각이 되도록 패드에 맞춰준 후 손잡이를 잡은 후 팔꿈치를 멀리 보낸다는 느낌으로 벌려준다" +
                "\n*저중량 고반복이 효과적이다" +
                "\n\n효과 : 래터럴 레이즈는 측면 삼각근을 단련하는 운동이다.  양손에 덤벨을 들고 실시하는 것이 보통이나 케이블, 머신 등으로 대체할 수도 있다" +
                "\n\n주의점 : 팔꿈치가 어깨보다 더 높게 올라가지 않게 한다 ";

        private String a8 = "\n기구 이름 : 레그익스텐션 " +
                "\n주운동 부위 :허벅지 앞 " +
                "\n부운동부위 : 대퇴사두근 " +
                "\n\n운동 방법 : " +
                "\n1.등받이에 등을 대고 손잡이를 잡은 다음, 발목을 어깨너비보다 좁게 벌려서 롤패드에 고정시킨다" +
                "\n2.다리를 들어올려 무릎을 펴서 허벅지 근육을 수축시킨다 " +
                "\n3.천천히 저항을 느끼면서 다리를 내리며 긴장을 유지한다 " +
                "\n*또한 두 다리의 근력 수준 차이를 극복하기 위해 한 발씩 실시해도 좋은 운동 " +
                "\n\n효과 :허벅지 전면 근육을 발달시키는 운동이다. 여성의 경우, 적당한 무게로 횟수를 늘려 실시하면 탄력 있는 허벅지를 만드는 데 효과적이다" +
                "\n\n주의점 :상체에 반동이 일어나지 않도록 천천히 실시";

        private String a9 = "\n기구 이름 : 레그프레스" +
                "\n주운동 부위 : 대퇴사두근 " +
                "\n부운동부위 : 대둔근 , 슬굴곡근" +
                "\n\n운동 방법 : " +
                "\n1.머신에 앉아 엉덩이와 어꺠를 밀착시킨 후 양발을 발판에 대고 어깨너비만큼 벌린 다음 무릎을 핀다" +
                "\n2.앉는다는 느낌으로 천천히 무릎이 90도가 될 때까지 구부린다, 발 뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 무릎을 편다 " +
                "\n*발판의 보폭을 좁게 하면 대퇴부 바깥쪽이, 넓게 하면 대퇴부 안쪽이 발달된다." +
                "\n*발을 발판의 윗쪽에 대고 하면 대둔근이, 발을 발판의 아래쪽에 대고 하면 대퇴사두근 아래쪽이 발달된다." +
                "\n\n효과 :대퇴사두근과 둔근을 강화시켜주는 대표적이고 필수적인 하체 운동이다. 초보자가 실시하기에 가장 적당한 하체 운동이며 스쿼트에 비해 허리에 가해지는 부하가 적어 비교적 무거운 무게로 운동을 할 수 있는 장점이 있다" +
                "\n\n주의점 : 무릎을 완전히 펴지 말고 약간 구부려주는 것이 운동 효과에 좋다, 엉덩이와 허리가 항상 기구에 밀착해 있어야 한다.";

        private String a10 = "\n기구 이름 : 레그컬머신" +
                "\n주운동 부위 : 넙다리뒤근육(햄스트링)" +
                "\n부운동부위 : 종아리근육" +
                "\n\n운동 방법 : " +
                "\n1.머신에 엎드려서 자세를 잡는다, 다리패드가 아킬레스건 위에 위치할수 있게 한다 " +
                "\n2.허벅지 뒷근육을 이용해서 당겨준다, 발끝은 다리와 90도가 되도록하며, 최대한 엉덩이까지 당겨준다  " +
                "\n3.천천히 다리를 펴준다 " +
                "\n*고중량 저반복이 효과적이다, " +
                "\n\n효과 : 대퇴후면의 슬굴곡근을 발달시키기 위한 운동이다. 스탠딩 레그 컬보다 많은 중량을 들 수 있는 것이 장점으로, 하체 근력이 약한 사람에게 필수적인 운동이다" +
                "\n\n주의점 :엉덩이가 들리지 않게한다 , 반동을 주지 않는다 ";

        private String a11 = "\n기구 이름 : 시티드딥스" +
                "\n주운동 부위 : 가슴(대흉근) 하부" +
                "\n부운동부위 : 상완삼두근과 전면 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 손잡이를 잡고 허벅지를 패드에 고정시켜준 후 상체를 앞으로 살짝 숙여준다 " +
                "\n2.숨을 내쉬면서 가슴의 힘을 최대한 사용하여 팔꿈치가 완전히 펴지기 직전까지 아래로 꾹 눌러준다 " +
                "\n*일반 딥스보다 부상 위험이 적고 , 딥스를 하기 어려운 초보자에게 매우 유용한운동" +
                "\n\n효과 : 디클라인 벤치 프레스와 함께 대흉근의 하부를 발달시키는 데 효과적인 운동" +
                "\n\n주의점 : 상체를 앞으로 살짝 숙일때 허리, 가슴은 꼭 펴줘야한다, 어깨각도에 주의해야한다";


        private String a12 = "\n기구 이름 : 숄더프레스머신" +
                "\n주운동 부위 : 삼각근(어깨)" +
                "\n부운동부위 : 상완삼두근 , 승모근 상부" +
                "\n\n운동 방법 : " +
                "\n1.머신에 앉아 엉덩이와 어깨를 벤치에 밀착시킨다.어깨너비 두 배 정도로 양손을 벌린 상태에서 손바닥이 앞을 향하도록 바를 잡는다" +
                "\n2.손으로 밀지 말고 어깨로 드는 느낌으로 중량을 밀어 올린다" +
                "\n3.저항을 느끼면서 서서히 바가 귀와 평행하게 될 때까지 내린다" +
                "\n*머신을 이용하기 때문에 동작의 컨트롤이 용이하고 안정된 자세로 좀 더 많은 중량을 다룰 수 있다는 장점이 있다" +
                "\n*팔꿈치를 완전히 펴면 삼각근에 자극이 풀어지게 되므로 완전히 신전하지 않는다" +
                "\n\n효과 : 삼각근의 전면과 측면의 볼륨을 키울 수 있는 다관절 운동" +
                "\n\n주의점 :바가 지나치게 내려오게 되면 어깨에 부상을 유발할 수 있으므로 귀 높이까지만 동작한다" +
                "\n*중력 방향에 대한 저항만이 근육에 가해지기 때문에 다양한 자극을 부여하기는 어려운 점이 있다";

        private String a13 = "\n기구 이름 : 스미스머신(1번은 가슴, 2번은 하체운동)" +
                "\n\n1번\n주운동 부위 : 흉근(가슴)" +
                "\n\n운동 방법 : " +
                "\n1.봉이 내려올때 가슴 위쪽에 닿게 셋팅한 후 벤치에 누워서 허리를 아치형으로 만들어준다" +
                "\n2.바벨을 잡고 숨을 들이마시며 천천히 가슴위쪽까지 내린후 호흡을 뱉으며 힘있게 밀어 올린다" +
                "\n\n효과 :프리웨이트로 시행하면 가벼운 무게도 흔들리기때문에 팔힘이 비교적 약한 초보자들에게 좋다" +
                "\n\n주의점 : 궤적이 고정되있기때문에 팔꿈치나 손목 부상에 조심해야한다" +

                "\n\n2번\n주운동 부위 : 대퇴사두근(허벅지앞쪽)" +
                "\n부운동부위 : 대둔근,술굴곡근" +
                "\n\n운동 방법 : " +
                "\n1.바벨을 어깨 위에 올리고 어깨너비보다 넓게 바벨을 잡는다.스쿼트 랙 아래에서 어깨너비로 서서 발끝이 약간 바깥쪽으로 향하도록 한다" +
                "\n2.무릎이 허벅지와 수평이 될때까지 앉는다" +
                "\n3.발뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 일어선다 " +
                "\n*무릎과 등 하부에 부담을 줄이고 대퇴를 강도 높게 자극할 수 있다" +
                "\n\n효과 : 바벨 스쿼트 운동에 비해 고립된 운동으로 대퇴부와 둔부 크기를 증가시키기 위한 운동 " +
                "\n\n주의점 : 안정성을 위해 허리는 항상 곧게 편다, 무릎을 바깥쪽 또는 안쪽으로 굽히지 말고, 일정하게 수평을 이루며 동작을 실시한다";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            Intent intent = getIntent();
            String name0 = intent.getExtras().getString("name0");
            if (name0.equals("체스트프레스머신")) {
                textviewHtmlDocument.setText(a1);
            } else if (name0.equals("랫풀다운")) {
                textviewHtmlDocument.setText(a2);
            } else if (name0.equals("시티드로우")) {
                textviewHtmlDocument.setText(a3);
            } else if (name0.equals("암컬머신")) {
                textviewHtmlDocument.setText(a4);
            } else if (name0.equals("체스트플라이머신")) {
                textviewHtmlDocument.setText(a5);
            } else if (name0.equals("치닝디핑")) {
                textviewHtmlDocument.setText(a6);
            } else if (name0.equals("레터럴레이즈머신")) {
                textviewHtmlDocument.setText(a7);
            } else if (name0.equals("레그익스텐션")) {
                textviewHtmlDocument.setText(a8);
            } else if (name0.equals("레그프레스")) {
                textviewHtmlDocument.setText(a9);
            } else if (name0.equals("레그컬머신")) {
                textviewHtmlDocument.setText(a10);
            } else if (name0.equals("시티드딥스")) {
                textviewHtmlDocument.setText(a11);
            } else if (name0.equals("숄더프레스머신")) {
                textviewHtmlDocument.setText(a12);
            } else if (name0.equals("스미스머신")) {
                textviewHtmlDocument.setText(a13);
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        arrayList = new ArrayList<>();
        final Bundle bundle = new Bundle();
        foodView = findViewById(R.id.food_list);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urls = "https://www.youtube.com/results?search_query=";
                Intent intent = getIntent();
                String name0 = intent.getExtras().getString("name0");
                Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + name0));
                startActivity(intents);
            }
        });
        textviewHtmlDocument = (TextView) findViewById(R.id.textView);
        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());
        ImageView workout_view = (ImageView) findViewById(R.id.workout_view);
        TextView workout_name = (TextView) findViewById(R.id.workout_name);
        TextView tv_name = (TextView) findViewById(R.id.tv_name);

        HorizontalScrollView scroll = (HorizontalScrollView) findViewById(R.id.routine);
        HorizontalScrollView scroll2 = (HorizontalScrollView) findViewById(R.id.routine2);
        LinearLayout layout = (LinearLayout) findViewById(R.id.routine_view);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.routine_view2);
        LinearLayout lin = (LinearLayout) findViewById(R.id.sub_activity_layout);

        ScrollView sub_activity_page = (ScrollView) findViewById(R.id.sub_activity_page);

        SubLayout subLayout = null;

        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute(drwNoUrl, nowCnt);

        String a1 = "\n기구 이름 : 체스트프레스머신" +
                "\n주운동 부위 : 가슴근육(대흉근)" +
                "\n부운동부위 : 상완삼두근 및 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.손잡이와 가슴 높이가 비슷하게 위치하도록 의자 높낮이를 조정해준다" +
                "\n2.가슴을 펴고 허리가 과하게 꺽이지 않게 바르게 펴고 팔을 앞으로 밀어준다 " +
                "\n3.손목, 팔꿈치를 일직선을 유지시킨 상태에서 팔꿈치를 뒤로 천천히 빼준다" +
                "\n\n효과 : 가슴 및 팔 근육을 키울 수 있다" +
                "\n\n주의점 : 손잡이를 잡을 때 너무 과하게 손목이 꺾이지 않기 , 불필요하게 승모에 힘주지 않기";

        String a2 = "\n기구 이름 : 랫풀다운머신" +
                "\n주운동 부위 : 광배근" +
                "\n부운동부위 : 이두근" +
                "\n\n운동 방법 : " +
                "\n1.턱걸이를 하듯 어깨보다 좀 더 넓게 바를 잡는다" +
                "\n2.상체를 뒤로 젖히고 팔이 아니라 등의 힘으로 당겨 내려온다" +
                "\n*턱걸이와 가동부위는 거의 같으며, 좁게 잡을수록 광배근 안쪽이, 넓게 잡을수록 상부와 바깥쪽이 발달된다" +
                "\n\n효과 : 광배근을 발달시키기 위한 대표적인 운동이다, 턱걸이를 하기 어려운 초보자들에게 좋은 운동이다" +
                "\n\n주의점 : 팔만 이용하여 바(bar)를 잡아당기면 이두근의 참여도가 지나치게 높아지므로 동작을 시작하는 시점에서 견갑골(날개뼈)을 우선적으로 내리도록 한다";

        String a3 = "\n기구 이름 : 시티드로우" +
                "\n주운동 부위 : 광배근" +
                "\n부운동부위 : 중부 승모근 , 하부 승모근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아서 발판에 발을 올리고 그립을 잡고 척추를 바르게 편다 " +
                "\n2.호흡을 들이마시며 가슴을 들고 견갑골을 모아주며 그립을 당겨준다 " +
                "\n3.숨을 내뱉으며 팔과 견갑골을 펴준다" +
                "\n\n효과 : 등 근육의 크기를 키우는 운동으로 광배근 하부 크기에 관여하는 운동 , 벤트 오버 로우 동작을 앉아서 케이블을 이용해 하는 운동이다" +
                "\n\n주의점 : 팔꿈치로 당긴다기보다 견갑곱을 모으는데 집중해주고 척추중립을 유지해준다";

        String a4 = "\n기구 이름 : 암컬머신" +
                "\n주운동 부위 : 상완이두근" +
                "\n부운동부위 : 전완근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 바벨을 어깨 너비로 잡는다 " +
                "\n2.가슴과 팔을 패드에 고정시킨 후 손을 몸쪽으로 올려 이두를 수축시킨다 " +
                "\n*좁게 잡으면 장두 , 넓게 잡으면 단두운동이된다 " +
                "\n\n효과 : 고정된 팔꿈치로 인해 강력한 상완 이두근 운동을 할 수 있는 머신이다. 등, 어깨의 개입을 최소화 하여 오직 이두에만 집중하기 위한 머신" +
                "\n\n주의점 :  손목이 안으로 꺽이지 않게 한다. 반동을 이용하지 않는다";

        String a5 = "\n기구 이름 : 체스트 플라이 머신" +
                "\n주운동 부위 : 대흉근(가슴) 내측근(중앙)" +
                "\n부운동부위 : 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 허리는 살짝 아치형을 만든후 손잡이를 잡은 뒤 ,가슴을 모아준다 " +
                "\n2.가슴을 늘려준다는 느낌으로 천천히 이완한다 " +
                "\n*팔힘을 이용해 수축시켜 주는 느낌이 아닌, 겨드랑이에 힘을 주고 가슴을 모아준다는 느낌으로 수축시켜준다" +
                "\n\n효과 : 운동을 처음 시작하는 초보자들이 덤벨 플라이를 실시하기 전에 근육의 자극을 경험하고 자세를 교정하는 데 효과적이다. 대흉근에집중하기에 좋은 운동이다" +
                "\n\n주의점 : 다리를 사용하지 않는다, 허리가 굽히지 않게 신경쓰면서 천천히 수축 이완을 한다";

        String a6 = "\n기구 이름 : 치닝디핑 (1번은 가슴, 2번은 등)" +
                "\n\n1번\n주운동 부위 : 가슴(대흉근) 하부" +
                "\n부운동부위 : 삼각근, 삼두" +
                "\n\n운동 방법 : " +
                "\n1.바를 잡고 팔꿈치를 펴고 선다" +
                "\n2.팔꿈치를 굽혀주면서 상체를 내려준다" +
                "\n3.팔꿈치를 다시 펴 원위치한다" +
                "\n\n주의점 :초보자의 경우 과도하게 내려가려다가 팔꿈치나 어깨가 망가질 수 있으니 주의해야한다 " +

                "\n\n2번\n주운동 부위 : 등" +
                "\n부운동부위 : 이두 " +
                "\n\n운동 방법 : " +
                "\n1.어깨넓이보다 약간 더 넓게 오버핸드그립(손목이 아래로 향하여 쥐는형태)자세로 점프하여 바를 잡는다   " +
                "\n2.등,코어,둔근을 자극하며 어깨뼈를 앞에서 뒤로 당긴다, 턱이 턱걸이 봉을 지날때까지 몸을 들어올린다" +
                "\n3.천천히 몸을 돌리며 다시 처음으로 돌아온다" +
                "\n\n주의점 :횟수보다는 올바른 방법이 중요하다, 동작이 안되면 밴드를 이용하거나 매달리기 부터 하길 권장한다";

        String a7 = "\n기구 이름 : 레터럴레이즈머신" +
                "\n주운동 부위 : 측면 삼각근" +
                "\n부운동부위 : 전면 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 어깨선을 맞춰서 의자 높이를 조절한다" +
                "\n2.팔꿈치는 직각이 되도록 패드에 맞춰준 후 손잡이를 잡은 후 팔꿈치를 멀리 보낸다는 느낌으로 벌려준다" +
                "\n*저중량 고반복이 효과적이다" +
                "\n\n효과 : 래터럴 레이즈는 측면 삼각근을 단련하는 운동이다.  양손에 덤벨을 들고 실시하는 것이 보통이나 케이블, 머신 등으로 대체할 수도 있다" +
                "\n\n주의점 : 팔꿈치가 어깨보다 더 높게 올라가지 않게 한다 ";

        String a8 = "\n기구 이름 : 레그익스텐션 " +
                "\n주운동 부위 :허벅지 앞 " +
                "\n부운동부위 : 대퇴사두근 " +
                "\n\n운동 방법 : " +
                "\n1.등받이에 등을 대고 손잡이를 잡은 다음, 발목을 어깨너비보다 좁게 벌려서 롤패드에 고정시킨다" +
                "\n2.다리를 들어올려 무릎을 펴서 허벅지 근육을 수축시킨다 " +
                "\n3.천천히 저항을 느끼면서 다리를 내리며 긴장을 유지한다 " +
                "\n*또한 두 다리의 근력 수준 차이를 극복하기 위해 한 발씩 실시해도 좋은 운동 " +
                "\n\n효과 :허벅지 전면 근육을 발달시키는 운동이다. 여성의 경우, 적당한 무게로 횟수를 늘려 실시하면 탄력 있는 허벅지를 만드는 데 효과적이다" +
                "\n\n주의점 :상체에 반동이 일어나지 않도록 천천히 실시";

        String a9 = "\n기구 이름 : 레그프레스" +
                "\n주운동 부위 : 대퇴사두근 " +
                "\n부운동부위 : 대둔근 , 슬굴곡근" +
                "\n\n운동 방법 : " +
                "\n1.머신에 앉아 엉덩이와 어꺠를 밀착시킨 후 양발을 발판에 대고 어깨너비만큼 벌린 다음 무릎을 핀다" +
                "\n2.앉는다는 느낌으로 천천히 무릎이 90도가 될 때까지 구부린다, 발 뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 무릎을 편다 " +
                "\n*발판의 보폭을 좁게 하면 대퇴부 바깥쪽이, 넓게 하면 대퇴부 안쪽이 발달된다." +
                "\n*발을 발판의 윗쪽에 대고 하면 대둔근이, 발을 발판의 아래쪽에 대고 하면 대퇴사두근 아래쪽이 발달된다." +
                "\n\n효과 :대퇴사두근과 둔근을 강화시켜주는 대표적이고 필수적인 하체 운동이다. 초보자가 실시하기에 가장 적당한 하체 운동이며 스쿼트에 비해 허리에 가해지는 부하가 적어 비교적 무거운 무게로 운동을 할 수 있는 장점이 있다" +
                "\n\n주의점 : 무릎을 완전히 펴지 말고 약간 구부려주는 것이 운동 효과에 좋다, 엉덩이와 허리가 항상 기구에 밀착해 있어야 한다.";

        String a10 = "\n기구 이름 : 레그컬머신" +
                "\n주운동 부위 : 넙다리뒤근육(햄스트링)" +
                "\n부운동부위 : 종아리근육" +
                "\n\n운동 방법 : " +
                "\n1.머신에 엎드려서 자세를 잡는다, 다리패드가 아킬레스건 위에 위치할수 있게 한다 " +
                "\n2.허벅지 뒷근육을 이용해서 당겨준다, 발끝은 다리와 90도가 되도록하며, 최대한 엉덩이까지 당겨준다  " +
                "\n3.천천히 다리를 펴준다 " +
                "\n*고중량 저반복이 효과적이다, " +
                "\n\n효과 : 대퇴후면의 슬굴곡근을 발달시키기 위한 운동이다. 스탠딩 레그 컬보다 많은 중량을 들 수 있는 것이 장점으로, 하체 근력이 약한 사람에게 필수적인 운동이다" +
                "\n\n주의점 :엉덩이가 들리지 않게한다 , 반동을 주지 않는다 ";

        String a11 = "\n기구 이름 : 시티드딥스" +
                "\n주운동 부위 : 가슴(대흉근) 하부" +
                "\n부운동부위 : 상완삼두근과 전면 삼각근" +
                "\n\n운동 방법 : " +
                "\n1.벤치에 앉아 손잡이를 잡고 허벅지를 패드에 고정시켜준 후 상체를 앞으로 살짝 숙여준다 " +
                "\n2.숨을 내쉬면서 가슴의 힘을 최대한 사용하여 팔꿈치가 완전히 펴지기 직전까지 아래로 꾹 눌러준다 " +
                "\n*일반 딥스보다 부상 위험이 적고 , 딥스를 하기 어려운 초보자에게 매우 유용한운동" +
                "\n\n효과 : 디클라인 벤치 프레스와 함께 대흉근의 하부를 발달시키는 데 효과적인 운동" +
                "\n\n주의점 : 상체를 앞으로 살짝 숙일때 허리, 가슴은 꼭 펴줘야한다, 어깨각도에 주의해야한다";

        String a12 = "\n기구 이름 : 숄더프레스머신" +
                "\n주운동 부위 : 삼각근(어깨)" +
                "\n부운동부위 : 상완삼두근 , 승모근 상부" +
                "\n\n운동 방법 : " +
                "\n1.머신에 앉아 엉덩이와 어깨를 벤치에 밀착시킨다.어깨너비 두 배 정도로 양손을 벌린 상태에서 손바닥이 앞을 향하도록 바를 잡는다" +
                "\n2.손으로 밀지 말고 어깨로 드는 느낌으로 중량을 밀어 올린다" +
                "\n3.저항을 느끼면서 서서히 바가 귀와 평행하게 될 때까지 내린다" +
                "\n*머신을 이용하기 때문에 동작의 컨트롤이 용이하고 안정된 자세로 좀 더 많은 중량을 다룰 수 있다는 장점이 있다" +
                "\n*팔꿈치를 완전히 펴면 삼각근에 자극이 풀어지게 되므로 완전히 신전하지 않는다" +
                "\n\n효과 : 삼각근의 전면과 측면의 볼륨을 키울 수 있는 다관절 운동" +
                "\n\n주의점 :바가 지나치게 내려오게 되면 어깨에 부상을 유발할 수 있으므로 귀 높이까지만 동작한다" +
                "\n*중력 방향에 대한 저항만이 근육에 가해지기 때문에 다양한 자극을 부여하기는 어려운 점이 있다";

        String a13 = "\n기구 이름 : 스미스머신(1번은 가슴, 2번은 하체운동)" +
                "\n\n1번\n주운동 부위 : 흉근(가슴)" +
                "\n\n운동 방법 : " +
                "\n1.봉이 내려올때 가슴 위쪽에 닿게 셋팅한 후 벤치에 누워서 허리를 아치형으로 만들어준다" +
                "\n2.바벨을 잡고 숨을 들이마시며 천천히 가슴위쪽까지 내린후 호흡을 뱉으며 힘있게 밀어 올린다" +
                "\n\n효과 :프리웨이트로 시행하면 가벼운 무게도 흔들리기때문에 팔힘이 비교적 약한 초보자들에게 좋다" +
                "\n\n주의점 : 궤적이 고정되있기때문에 팔꿈치나 손목 부상에 조심해야한다" +

                "\n\n2번\n주운동 부위 : 대퇴사두근(허벅지앞쪽)" +
                "\n부운동부위 : 대둔근,술굴곡근" +
                "\n\n운동 방법 : " +
                "\n1.바벨을 어깨 위에 올리고 어깨너비보다 넓게 바벨을 잡는다.스쿼트 랙 아래에서 어깨너비로 서서 발끝이 약간 바깥쪽으로 향하도록 한다" +
                "\n2.무릎이 허벅지와 수평이 될때까지 앉는다" +
                "\n3.발뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 일어선다 " +
                "\n*무릎과 등 하부에 부담을 줄이고 대퇴를 강도 높게 자극할 수 있다" +
                "\n\n효과 : 바벨 스쿼트 운동에 비해 고립된 운동으로 대퇴부와 둔부 크기를 증가시키기 위한 운동 " +
                "\n\n주의점 : 안정성을 위해 허리는 항상 곧게 편다, 무릎을 바깥쪽 또는 안쪽으로 굽히지 말고, 일정하게 수평을 이루며 동작을 실시한다";

        // ## 운동기구 루틴 ##
        arrayList = new ArrayList<>();
        Intent intent = getIntent();
        String name0 = intent.getExtras().getString("name0");
        if (name0.equals("스미스머신")) {
            workout_view.setImageResource(R.drawable.smith_machine);
            workout_name.setText("스미스 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "벤치 프레스\n(가슴)", R.drawable.img_smith));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));

            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "스쿼트\n(하체)", R.drawable.img_smith));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 레이아웃
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 레이아웃
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 레이아웃
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 레이아웃
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

        } else if (name0.equals("치닝디핑")) {
            workout_view.setImageResource(R.drawable.chining_dipping);
            workout_name.setText("치닝 디핑");
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "벤치 프레스\n(가슴)", R.drawable.img_smith));
//          for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("3세트", "8회", "치닝디핑\n(등)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 로우 머신\n(등)", R.drawable.img_seated_row));
            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a3);
                    workout_view.setImageResource(R.drawable.seated_row);
                    workout_name.setText("시티드 로우 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }

        } else if (name0.equals("숄더프레스머신")) {
            workout_view.setImageResource(R.drawable.shoulder_press);
            workout_name.setText("숄더 프레스 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "10회", "스쿼트\n(하체)", R.drawable.img_smith));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 컬 머신\n(하체)", R.drawable.img_legcurl));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a10);
                    workout_view.setImageResource(R.drawable.leg_curl);
                    workout_name.setText("레그 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }

        } else if (name0.equals("시티드딥스")) {
            workout_view.setImageResource(R.drawable.seated_dip_machine);
            workout_name.setText("시티드 딥스 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "벤치 프레스\n(가슴)", R.drawable.img_smith));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 프레스 머신\n(가슴)", R.drawable.img_chesspress));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a1);
                    workout_view.setImageResource(R.drawable.chest_press);
                    workout_name.setText("체스트 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });


//            }


        } else if (name0.equals("레그컬머신")) {
            workout_view.setImageResource(R.drawable.leg_curl);
            workout_name.setText("레그 컬 머신");
            arrayList.add(new Workout_Item("4세트", "12회", "레그 컬 머신\n(하체)", R.drawable.img_legcurl));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a10);
                    workout_view.setImageResource(R.drawable.leg_curl);
                    workout_name.setText("레그 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }

        } else if (name0.equals("레그프레스")) {
            workout_view.setImageResource(R.drawable.leg_press);
            workout_name.setText("레그 프레스 머신");
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 컬 머신\n(하체)", R.drawable.img_legcurl));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a10);
                    workout_view.setImageResource(R.drawable.leg_curl);
                    workout_name.setText("레그 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "10회", "스쿼트\n(하체)", R.drawable.img_smith));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }

        } else if (name0.equals("레그익스텐션")) {
            workout_view.setImageResource(R.drawable.leg_extension);
            workout_name.setText("레그 익스텐션 머신");
            arrayList.add(new Workout_Item("4세트", "12회", "레그 익스텐션\n(하체)", R.drawable.img_legextention));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 컬 머신\n(하체)", R.drawable.img_legcurl));
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a7);
                    workout_view.setImageResource(R.drawable.leg_extension);
                    workout_name.setText("레그 익스텐션 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a10);
                    workout_view.setImageResource(R.drawable.leg_curl);
                    workout_name.setText("레그 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }

        } else if (name0.equals("레터럴레이즈머신")) {
            workout_view.setImageResource(R.drawable.lateral_raise);
            workout_name.setText("레터럴 레이즈 머신");
            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈\n머신 (어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 프레스 머신\n(하체)", R.drawable.img_legpress));
            arrayList.add(new Workout_Item("4세트", "10회", "스쿼트\n(하체)", R.drawable.img_smith));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a9);
                    workout_view.setImageResource(R.drawable.leg_press);
                    workout_name.setText("레그 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "15회", "레터럴 레이즈 머신\n(어깨)", R.drawable.img_lateralraise));
            arrayList.add(new Workout_Item("4세트", "10회", "숄더 프레스 머신\n(어깨)", R.drawable.img_shoulderpress));
            arrayList.add(new Workout_Item("4세트", "10회", "레그 익스텐션\n(하체)", R.drawable.img_legextention));
            arrayList.add(new Workout_Item("4세트", "12회", "레그 컬 머신\n(하체)", R.drawable.img_legcurl));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a8);
                    workout_view.setImageResource(R.drawable.lateral_raise);
                    workout_name.setText("레터럴 레이즈 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a12);
                    workout_view.setImageResource(R.drawable.shoulder_press);
                    workout_name.setText("숄더 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a7);
                    workout_view.setImageResource(R.drawable.leg_extension);
                    workout_name.setText("레그 익스텐션 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a10);
                    workout_view.setImageResource(R.drawable.leg_curl);
                    workout_name.setText("레그 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
        } else if (name0.equals("체스트플라이머신")) {
            workout_view.setImageResource(R.drawable.chest_fly);
            workout_name.setText("체스트 플라이 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "벤치 프레스\n(가슴)", R.drawable.img_smith));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a13);
                    workout_view.setImageResource(R.drawable.smith_machine);
                    workout_name.setText("스미스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 프레스 머신\n(가슴)", R.drawable.img_chesspress));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a1);
                    workout_view.setImageResource(R.drawable.chest_press);
                    workout_name.setText("체스트 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
        } else if (name0.equals("암컬머신")) {
            workout_view.setImageResource(R.drawable.bicep_curl);
            workout_name.setText("암 컬 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
//            }
            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
            arrayList.add(new Workout_Item("4세트", "10회", "랫 풀 다운\n(등)", R.drawable.img_latpulldown));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 로우 머신\n(등)", R.drawable.img_seated_row));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a2);
                    workout_view.setImageResource(R.drawable.lat_pulldown);
                    workout_name.setText("랫 풀 다운");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a3);
                    workout_view.setImageResource(R.drawable.seated_row);
                    workout_name.setText("시티드 로우 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
        } else if (name0.equals("시티드로우")) {
            workout_view.setImageResource(R.drawable.seated_row);
            workout_name.setText("시티드 로우 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 로우 머신\n(등)", R.drawable.img_seated_row));
            arrayList.add(new Workout_Item("3세트", "8회", "치닝디핑\n(등)", R.drawable.img_chiningdipping));
            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a3);
                    workout_view.setImageResource(R.drawable.seated_row);
                    workout_name.setText("시티드 로우 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            arrayList = new ArrayList<>();

            arrayList.add(new Workout_Item("4세트", "10회", "시티드 로우 머신\n(등)", R.drawable.img_seated_row));
            arrayList.add(new Workout_Item("4세트", "10회", "랫 풀 다운\n(등)", R.drawable.img_latpulldown));
            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a3);
                    workout_view.setImageResource(R.drawable.seated_row);
                    workout_name.setText("시티드 로우 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a2);
                    workout_view.setImageResource(R.drawable.lat_pulldown);
                    workout_name.setText("랫 풀 다운");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            layout2.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

        } else if (name0.equals("랫풀다운")) {
            workout_view.setImageResource(R.drawable.lat_pulldown);
            workout_name.setText("랫 풀 다운");
            arrayList.add(new Workout_Item("4세트", "10회", "랫 풀 다운\n(등)", R.drawable.img_latpulldown));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 로우 머신\n(등)", R.drawable.img_seated_row));
            arrayList.add(new Workout_Item("4세트", "10회", "암 컬 머신\n(이두)", R.drawable.img_armcurl));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a2);
                    workout_view.setImageResource(R.drawable.lat_pulldown);
                    workout_name.setText("랫 풀 다운");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a3);
                    workout_view.setImageResource(R.drawable.seated_row);
                    workout_name.setText("시티드 로우 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a4);
                    workout_view.setImageResource(R.drawable.bicep_curl);
                    workout_name.setText("암 컬 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

//            }
        } else if (name0.equals("체스트프레스머신")) {
            workout_view.setImageResource(R.drawable.chest_press);
            workout_name.setText("체스트 프레스 머신");
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 프레스 머신\n(가슴)", R.drawable.img_chesspress));
            arrayList.add(new Workout_Item("4세트", "10회", "체스트 플라이 머신\n(가슴)", R.drawable.img_chestfly));
            arrayList.add(new Workout_Item("4세트", "10회", "시티드 딥스 머신\n(삼두)", R.drawable.img_seateddips));
            arrayList.add(new Workout_Item("4세트", "10회", "치닝디핑\n(삼두)", R.drawable.img_chiningdipping));
//            for (int i = 0; i < arrayList.size(); i++) {
            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(0));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a1);
                    workout_view.setImageResource(R.drawable.chest_press);
                    workout_name.setText("체스트 프레스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(1));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a5);
                    workout_view.setImageResource(R.drawable.chest_fly);
                    workout_name.setText("체스트 플라이 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(2));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a11);
                    workout_view.setImageResource(R.drawable.seated_dip_machine);
                    workout_name.setText("시티드 딥스 머신");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });

            // 추가할 레이아웃
            subLayout = new SubLayout(getApplicationContext(), arrayList.get(3));
            // 추가될 위치
            layout.addView(subLayout);
            subLayout.iv_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sub_activity_page.fullScroll(ScrollView.FOCUS_UP);
                    textviewHtmlDocument.setText(a6);
                    workout_view.setImageResource(R.drawable.chining_dipping);
                    workout_name.setText("치닝 디핑");
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urls = "https://www.youtube.com/results?search_query=";
                            Intent intents = new Intent(Intent.ACTION_VIEW, Uri.parse(urls + workout_name.getText()));
                            startActivity(intents);
                        }
                    });
                }
            });
        }
    }
}