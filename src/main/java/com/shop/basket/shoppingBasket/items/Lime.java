package com.shop.basket.shoppingBasket.items;

import com.shop.basket.shoppingBasket.util.Utils;

public class Lime extends Item {

    public Lime(Double unitPrice, Integer discountFactor, Double discountedPrice) {
        this.itemCode = Utils.LIME;
        this.unitPrice = unitPrice;
        this.discountFactor = discountFactor;
        this.discountedPrice = discountedPrice;
    }
    public Lime()
    {
         this.itemCode = Utils.LIME;
        this.unitPrice = 15.0;
        this.discountFactor = 3;
        this.discountedPrice = 30.0;
    }





}
