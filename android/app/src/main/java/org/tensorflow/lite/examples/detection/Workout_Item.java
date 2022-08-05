package org.tensorflow.lite.examples.detection;

public class Workout_Item {
    /* 아이템의 정보를 담기 위한 클래스 */

    String set_num;
    String cnt_num;
    String name;
    int resId;

    public Workout_Item(String set_num, String cnt_num, String name, int resId) {
        this.set_num = set_num;
        this.cnt_num = cnt_num;
        this.name = name;
        this.resId = resId;
    }

    public String getNum() {
        return set_num;
    }
    public void setNum(String set_num) {
        this.set_num = set_num;
    }

    public String getNum2() {
        return cnt_num;
    }
    public void setNum2(String cut_num) {
        this.cnt_num = cnt_num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }
}