package com.burning8393.bridge.v4;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Book());
        give(mm, g);
    }

    public void give(MM mm, Gift g) {
        System.out.println(g + "gived");
    }
}
