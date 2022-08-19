package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SubLayout extends LinearLayout {

    private Context context;
    public ImageView iv_icon;
    public TextView tv_name;
    public SubLayout(Context context, AttributeSet attrs, Workout_Item workoutItem) {

        super(context, attrs);
        init(context, workoutItem);
    }

    public SubLayout(Context context, Workout_Item workoutItem) {
        super(context);
        init(context, workoutItem);
    }

    private void init(Context context, Workout_Item workoutItem) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.routine_list_item, this, true);
        TextView tv_num = (TextView) findViewById(R.id.tv_num);
        TextView tv_set = (TextView) findViewById(R.id.tv_set);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_icon = (ImageView) findViewById(R.id.iv_icon);

        tv_num.setText(workoutItem.getNum());
        tv_set.setText(workoutItem.getNum2());
        tv_name.setText(workoutItem.getName());
        iv_icon.setImageResource(workoutItem.getResId());
    }

}
