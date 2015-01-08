package com.thoughtworks.rich.model.dots;

public class Hospital extends Dot {
    public Hospital(int no) {
        super(no);
    }

    public String defaultSymbol() {
        return "Y";
    }
}
