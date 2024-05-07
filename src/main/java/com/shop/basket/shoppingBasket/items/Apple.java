package com.shop.basket.shoppingBasket.items;

import com.shop.basket.shoppingBasket.util.Utils;

public class Apple extends Item {
    public Apple(Double unitPrice, Integer discountFactor, Double discountedPrice) {
        this.itemCode = Utils.APPLE;
        this.unitPrice = unitPrice;
        this.discountFactor = discountFactor;
        this.discountedPrice = discountedPrice;
    }

    public Apple() {
         this.itemCode = Utils.APPLE;
        this.unitPrice = 35.0;
         this.discountFactor = 0;
         this.discountedPrice = 0.0;
         this.itemTotal = 0.0;
    }





}
