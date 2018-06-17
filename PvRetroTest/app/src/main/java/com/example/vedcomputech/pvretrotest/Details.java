package com.example.vedcomputech.pvretrotest;

/**
 * Created by Ved Computech on 02-04-2018.
 */

public class Details {

    private int paper_height, paper_width;

    public Details(int paper_height, int paper_width) {
        this.paper_height = paper_height;
        this.paper_width = paper_width;
    }

    public int getPaper_height() {
        return paper_height;
    }

    public int getPaper_width() {
        return paper_width;
    }

    public void setPaper_height(int paper_height) {
        this.paper_height = paper_height;
    }

    public void setPaper_width(int paper_width) {
        this.paper_width = paper_width;
    }
}
