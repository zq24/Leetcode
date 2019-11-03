package qinz;

import java.util.ArrayList;

public class MovingAverage {

    /*private ArrayList<Integer> list;
    private int listSize;

    public MovingAverage(int size) {
        list = new ArrayList<>();
        listSize = size;
    }

    public double next(int val) {
        if(list.size() < listSize) {
            list.add(val);
        } else {
            list.remove(0);
            list.add(val);
        }
        double result = 0;
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result / list.size();
    }*/

    private int[] list;
    private int size;
    private double sum;
    private int start;
    public MovingAverage(int size) {
        this.list = new int[size];
        this.size = 0;
        this.sum = 0;
        this.start = 0;
    }

    public double next(int val) {
        if(this.size < this.list.length) {
            this.list[size] = val;
            this.size++;
            this.sum += val;
            return this.sum / this.size;
        } else {
            this.sum -= this.list[start];
            this.list[start] = val;
            this.start++;
            if(this.start >= list.length) {
                this.start = 0;
            }
            this.sum += val;
            return this.sum / this.size;
        }
    }

}
