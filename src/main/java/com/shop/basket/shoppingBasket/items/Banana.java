package com.shop.basket.shoppingBasket.items;

import com.shop.basket.shoppingBasket.util.Utils;

public class Banana extends Item {

    public Banana(Double unitPrice, Integer discountFactor, Double discountedPrice) {
        this.itemCode = Utils.BANANA;
        this.unitPrice = unitPrice;
        this.discountFactor = discountFactor;
        this.discountedPrice = discountedPrice;
    }

    public Banana()
    {
         this.itemCode = Utils.BANANA;
         this.unitPrice = 20.0;
         this.discountFactor = 0;
         this.discountedPrice = 0.0;
         this.itemTotal = 0.0;
    }





}
