package com.thoughtworks.rich.dots;

import com.thoughtworks.rich.io.IO;

public class Land extends Dot {
    private final int price;

    public Land(int no, int x, int y, int price) {
        super(no, x, y);
        this.price = price;
    }

    @Override
    protected void doInDot() {
        IO io = IO.getInstance();
        io.print("是否要购买本房产，花费" + price + "元");
        String line = io.nextLine();
        if("Y".equals(line)) {
            io.print("你已经购得" + no + "号房产，花费" + price + "元");
        }
    }

    public String defaultSymbol() {
        return "0";
    }
}
