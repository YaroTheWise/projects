package com.hackerrank.oneweek;

public class Model {
    private final int first;
    private final int last;
    private final String d;

    public Model (int first, int last, String d) {
        this.first = first;
        this.last = last;
        this.d = d;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    public String getD() {
        return d;
    }
}
